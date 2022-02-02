package me.birkheadc.twitterapi.session;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("session")
public class SessionController {
    @PostMapping("")
    public String login(@RequestParam(name = "userName") String userName,
                        @RequestParam(name = "password") String password) {
        return "token.token.token";
    }
}
