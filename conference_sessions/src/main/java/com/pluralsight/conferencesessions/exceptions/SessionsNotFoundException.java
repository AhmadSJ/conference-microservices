package com.pluralsight.conferencesessions.exceptions;

public class SessionsNotFoundException extends RuntimeException {
    public SessionsNotFoundException(String exception) { super(exception); }
}
