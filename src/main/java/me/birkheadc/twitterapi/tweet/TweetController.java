package me.birkheadc.twitterapi.tweet;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tweet")
public class TweetController {

    private final TweetModel model;

    public TweetController(TweetModel model) {
        this.model = model;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public Iterable<Tweet> test() {
        return model.getAllTweets();
    }

    @PostMapping("")
    public Tweet createTweet(@RequestHeader("Authorization") String auth,
                            @RequestBody TweetContents contents) {
        Tweet tweet = model.createTweet(auth, contents);
        return tweet;
    }

    @GetMapping("user/{userName}")
    public Iterable<Tweet> getAllByUser(@PathVariable("userName") String userName) {
        return model.getTweetsByUserName(userName);
    }
}
