package me.birkheadc.twitterapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserModel {

    private final UserRepository repository;

    public UserModel(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(String userName, String password) {
        User user = new User(userName, hashPassword(password));
        repository.save(user);
    }

    private String hashPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
