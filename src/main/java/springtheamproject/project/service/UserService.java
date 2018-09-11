package springtheamproject.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.Role;
import springtheamproject.project.model.User;
import springtheamproject.project.repository.UserRepository;
import springtheamproject.project.security.MyUserPrincipal;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userRepository.findAll());
    }

    public void add(User user){
        user.setNullId();
        user.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUser(Long id){
        try{
            return userRepository.findById(id).get();
        }catch(Exception notFoundException){
            return null;
        }
    }

    public void updateUser(Long id, User user) {
        User userToChange = getUser(id);
        if(userToChange == null) return;

        //check if the users id is saved in the db with the correct id.

        userRepository.save(user);
    }

    public void updatePartialUser(Long id, User user) {
        User userToChange = getUser(id);
        if (userToChange == null) return;

        if(user.getPassword() != null){
            userToChange.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword()));
        }
        if(user.getUsername() != null) userToChange.setUsername(user.getUsername());
        if(user.getRoles() != null){
            userToChange.setRoles(user.getRoles());

            //Updating roles if the current user being modified is who is requesting the update
            MyUserPrincipal loggedUser =
                    (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            changeCurrentRoles(user, userToChange, loggedUser);
        }

        userRepository.save(userToChange);
    }

    private void changeCurrentRoles(User user, User userToChange, MyUserPrincipal loggedUser) {
        if(loggedUser.getUsername().equals(userToChange.getUsername())){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            List<GrantedAuthority> newAuthorities = new ArrayList<>();
            for (Role role : user.getRoles()) {
                newAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),auth.getCredentials(),
                    newAuthorities);
            SecurityContextHolder.getContext().setAuthentication(newAuth);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
