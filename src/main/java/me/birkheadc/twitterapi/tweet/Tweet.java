package me.birkheadc.twitterapi.tweet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import me.birkheadc.twitterapi.user.User;

import javax.persistence.*;

@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    @JsonBackReference
    private User user;

    public Tweet() {

    }

    public Tweet(User user, String contents) {
        this.user = user;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
