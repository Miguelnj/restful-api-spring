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

    @GetMapping(userPath)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(userPath + "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping(userPath)
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping(userPath + "/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @PatchMapping(userPath+"/{id}")
    public void partialUpdatePassword(@PathVariable Long id, @RequestBody User partialUser){
        userService.updatePartialUser(id,partialUser);
    }

    @DeleteMapping(userPath + "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
