package me.birkheadc.twitterapi.user;

import me.birkheadc.twitterapi.security.LoginForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserModel {

    private final UserRepository repository;

    public UserModel(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(LoginForm loginForm) {
        String userName = loginForm.getUserName();
        String password = loginForm.getPassword();
        User user = new User(userName, hashPassword(password));
        repository.save(user);
    }

    private String hashPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    private boolean checkPassword(String password, String hash) {
        if (password == null || password == "") {
            return false;
        }
        System.out.println("Password: " + password + " Hash: " + hash);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hash);
    }

    private boolean doesUserExist(String userName) {
        User user = repository.findByUserName(userName);
        if (user == null) {
            return false;
        }
        return true;
    }

    public boolean isPasswordCorrect(String userName, String password) {
        if (doesUserExist(userName) == false) {
            return false;
        }

        User user = repository.findByUserName(userName);

        return checkPassword(password, user.getPassword());
    }
}
