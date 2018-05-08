package springtheamproject.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void add(User user){
        userRepository.save(user);
    }

    public User getUser(String id){
        return userRepository.findById(id).get();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
