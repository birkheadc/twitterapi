package me.birkheadc.twitterapi.tweet;

import me.birkheadc.twitterapi.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TweetModel {

    private final TweetRepository repository;

    public TweetModel(TweetRepository repository) {
        this.repository = repository;
    }

    public void createTweet(String token, String contents) {
        if (isAuthorized(token) == false) {
            return;
        }
        Tweet tweet = new Tweet(getUser(token), contents);
        repository.save(tweet);
    }

    private boolean isAuthorized(String token) {
        // TODO
        return true;
    }

    private User getUser(String token) {
        return null;
    }

    public Iterable<Tweet> getTweetsByUserName(String userName) {
        return repository.getAllByUserName(userName);
    }
}
