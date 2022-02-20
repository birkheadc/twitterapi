package me.birkheadc.twitterapi.session;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.birkheadc.twitterapi.security.LoginForm;
import me.birkheadc.twitterapi.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SessionModel {

    private final UserModel userModel;

    public SessionModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getToken(LoginForm loginForm) {

        String userName = loginForm.getUserName();
        String password = loginForm.getPassword();

        // Check username / password with user model

        if (userModel.isPasswordCorrect(userName, password) == false) {
            return "";
        }

        String secretKey = "secret"; // TODO: Change this
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("twitterJWT")
                .setSubject(loginForm.getUserName())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
