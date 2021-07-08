package com.microservice.conference_review.repositories;

import com.microservice.conference_review.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, Long> {

}
