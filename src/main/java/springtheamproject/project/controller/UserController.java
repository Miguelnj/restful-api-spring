package springtheamproject.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtheamproject.project.service.UserService;
import springtheamproject.project.model.User;

import java.util.List;

@RestController
public class UserController {

    public static final String userPath = "/users";
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(userPath)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(userPath + "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = userPath, method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @RequestMapping(value = userPath, method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = userPath + "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
