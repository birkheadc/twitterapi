package me.birkheadc.twitterapi.user;

import me.birkheadc.twitterapi.security.LoginForm;
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
    public void createUser(@RequestBody LoginForm loginForm) {
        model.createUser(loginForm);
    }
}
