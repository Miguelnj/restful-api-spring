package springtheamproject.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.User;

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
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void add(User user){
        user.setNullId();
        userRepository.save(user);
    }

    public User getUser(String id){
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

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
