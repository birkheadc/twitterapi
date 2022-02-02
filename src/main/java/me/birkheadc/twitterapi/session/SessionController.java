package me.birkheadc.twitterapi.session;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.birkheadc.twitterapi.security.TwitterUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public String login(@RequestParam(name = "userName") String userName,
                        @RequestParam(name = "password") String password) {

        String token = sessionModel.getToken(userName, password);

        return token;
    }
}
