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

    public void updateUser(User user) {
        if(getUser(user.getId()) == null) return;
        user.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword()));

        //Updating roles if the current user being modified is who is requesting the update
        MyUserPrincipal loggedUser =
                (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(loggedUser.getUsername().equals(user.getUsername())){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            List<GrantedAuthority> newAuthorities = new ArrayList<>();
            for (Role role : user.getRoles()) {
                newAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),auth.getCredentials(),
                    newAuthorities);
            SecurityContextHolder.getContext().setAuthentication(newAuth);
        }

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
