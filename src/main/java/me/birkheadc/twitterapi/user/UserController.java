package me.birkheadc.twitterapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserModel model;

    public UserController(UserModel model) {
        this.model = model;
    }

    @PostMapping("")
    public void createUser(@RequestParam(name = "userName") String userName,
                           @RequestParam(name = "password") String password) {
        model.createUser(userName, password);
    }
}
