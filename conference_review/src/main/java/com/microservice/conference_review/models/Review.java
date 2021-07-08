package com.microservice.conference_review.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "reviews")
public class Review {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long review_id;

    private String name;

    private String content;

    private String author;

    private String rating;

    private Long sessionId;

    private Long speakerId;


    public Review() {

    }

    @Override
    public String toString() {
        return String.format(
                "Review[review_id=%s, name='%s', content='%s', author='%s', rating='%s']",
                review_id, name, content, author, rating);
    }

    public Review(Long review_id, String name, String content, String author, String rating) {
        this.review_id = review_id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.rating = rating;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
