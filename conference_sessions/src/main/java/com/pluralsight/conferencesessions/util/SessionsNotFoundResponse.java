package com.pluralsight.conferencesessions.util;

public class SessionsNotFoundResponse {

    private String message;

    public SessionsNotFoundResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
