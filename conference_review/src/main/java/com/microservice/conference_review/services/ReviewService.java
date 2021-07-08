package com.microservice.conference_review.services;

import com.microservice.conference_review.models.Review;

import java.util.List;

public interface ReviewService {
    Review create(Review review);
    Review read(Long id);
    Review update(Long id, Review review);
    void delete(Long id);
    List<Review> listReviews();
    void deleteAll();
}
