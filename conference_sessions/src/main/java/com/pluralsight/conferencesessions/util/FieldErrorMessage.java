package com.pluralsight.conferencesessions.util;

public class FieldErrorMessage {
    private String message;
    private String errors;

    public FieldErrorMessage(String message, String errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
