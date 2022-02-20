package me.birkheadc.twitterapi.helpers;

import java.io.Serializable;

public class StringResponse implements Serializable {

    private String response;

    public StringResponse() {

    }

    public StringResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
