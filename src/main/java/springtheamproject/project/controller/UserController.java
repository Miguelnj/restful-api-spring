package springtheamproject.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtheamproject.project.business.UserService;
import springtheamproject.project.model.User;

import java.util.List;

@RestController
public class UserController {
    //CHECK THIS
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @RequestMapping(value = "users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
