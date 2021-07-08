package com.microservice.conference_review.services;

import com.microservice.conference_review.models.Review;
import com.microservice.conference_review.repositories.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.reviewRepository = reviewRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public Review create(Review review) {
        review.setReview_id(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
        return this.reviewRepository.save(review);
    }

    public Review read(Long id) {
        return this.reviewRepository.findById(id).get();
    }

    public Review update(Long id, Review review) {
        Review existingReview = this.reviewRepository.findById(id).get();
        BeanUtils.copyProperties(review, existingReview, "review_id");
        return this.reviewRepository.save(existingReview);
    }

    public void delete(Long id) {
        this.reviewRepository.deleteById(id);
    }

    public List<Review> listReviews() {
        return this.reviewRepository.findAll();
    }

    public void deleteAll() {
        List<Review> review = this.reviewRepository.findAll();
        for(Review rev : review){
            this.reviewRepository.deleteById(rev.getReview_id());
        }
    }


}
