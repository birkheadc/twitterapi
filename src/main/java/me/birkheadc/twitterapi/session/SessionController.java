package me.birkheadc.twitterapi.session;

import me.birkheadc.twitterapi.helpers.StringResponse;
import me.birkheadc.twitterapi.security.LoginForm;
import me.birkheadc.twitterapi.security.TwitterUserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("session")
public class SessionController {

    private final TwitterUserDetailsService userDetailsService;

    private final SessionModel sessionModel;

    public SessionController(TwitterUserDetailsService userDetailsService, SessionModel sessionModel) {
        this.userDetailsService = userDetailsService;
        this.sessionModel = sessionModel;
    }

    @PostMapping("")
    public StringResponse login(@RequestBody LoginForm loginForm) {
        String token = sessionModel.getToken(loginForm);

        if (token == "") {
            // TODO: return some kind of error
        }
        return new StringResponse(token);
    }
}
