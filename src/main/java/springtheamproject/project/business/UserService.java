package springtheamproject.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.Role;
import springtheamproject.project.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roles.add(role);
        roles.add(role2);
        user.setRoles(roles);
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
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
