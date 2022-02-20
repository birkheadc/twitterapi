package me.birkheadc.twitterapi.tweet;

import me.birkheadc.twitterapi.security.JwtTokenUtil;
import me.birkheadc.twitterapi.user.User;
import me.birkheadc.twitterapi.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TweetModel {

    private final TweetRepository tweetRepository;

    private final UserRepository userRepository;

    private final JwtTokenUtil tokenUtil;

    public TweetModel(TweetRepository tweetRepository, UserRepository userRepository, JwtTokenUtil tokenUtil) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
        this.tokenUtil = tokenUtil;
    }

    public Tweet createTweet(String auth, TweetContents contents) {
        User user = getUser(auth);
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }
        Tweet tweet = new Tweet(user, contents.getContents());
        tweetRepository.save(tweet);
        return tweet;
    }

    public User getUser(String auth) {
        String userName = tokenUtil.getUsernameFromAuth(auth);
        if (userName == null) {
            return null;
        }
        User user = userRepository.findByUserName(userName);
        return user;
    }

    public Iterable<Tweet> getTweetsByUserName(String userName) {
        return tweetRepository.findByUserOrderByTimeDesc(userName);
    }

    public Iterable<Tweet> getAllTweets() {
        return tweetRepository.findAllByOrderByTimeDesc();
    }
}
