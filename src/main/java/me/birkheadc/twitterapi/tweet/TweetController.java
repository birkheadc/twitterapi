package me.birkheadc.twitterapi.tweet;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tweet")
public class TweetController {

    private final TweetModel model;

    public TweetController(TweetModel model) {
        this.model = model;
    }

    @GetMapping("")
    public String test() {
        return "test";
    }

    @PostMapping("")
    public void createTweet(@RequestHeader("Authorization") String auth,
                            @RequestParam(name = "contents") String contents) {
        model.createTweet(auth, contents);
    }

    @GetMapping("user/{userName}")
    public Iterable<Tweet> getAllByUser(@PathVariable("userName") String userName) {
        return model.getTweetsByUserName(userName);
    }
}
