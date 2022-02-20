package me.birkheadc.twitterapi.security;

import java.io.Serializable;

public class LoginForm implements Serializable {
    private String userName;
    private String password;

    public LoginForm() {

    }

    public LoginForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String toString() {
        return "User Name: " + userName + " | Password: " + password + "\n";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
