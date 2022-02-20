package me.birkheadc.twitterapi.tweet;

import java.io.Serializable;

public class TweetContents implements Serializable {

    private String contents;

    public TweetContents() {

    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
