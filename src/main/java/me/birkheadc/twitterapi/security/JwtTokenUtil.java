package me.birkheadc.twitterapi.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtTokenUtil implements Serializable {

    private final String PREFIX = "Bearer ";
    private final String SECRET = "secret"; // TODO: Change this

    public String getUsernameFromAuth(String auth) {

        String token = auth.replace(PREFIX, "");
        String userName = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody().getSubject();

        return userName;
    }
}
