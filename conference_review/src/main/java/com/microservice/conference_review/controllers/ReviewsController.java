package com.microservice.conference_review.controllers;

import com.microservice.conference_review.models.Review;
import com.microservice.conference_review.services.ReviewService;
import com.microservice.conference_review.util.RestTemplateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/version1/reviews")
public class ReviewsController {
    private ReviewService reviewService;

    private RestTemplateConfiguration restTemplateConfiguration;

    @Autowired
    public ReviewsController(ReviewService reviewService, RestTemplateConfiguration restTemplateConfiguration) {
        this.reviewService = reviewService;
        this.restTemplateConfiguration = restTemplateConfiguration;
    }



    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.reviewService.listReviews());
    }

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review) {
        Long id;
        if(review.getSessionId()!=null){
            id = review.getSessionId();
        } else {
            id = review.getSpeakerId();
        }
        String url = "http://localhost:8080/api/version1/sessions/sessionid/" + id;
        RestTemplate restTemplate = restTemplateConfiguration.restTemplate();
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        System.out.println("RESPONSE: " + response);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(review);
    }

    @GetMapping
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> getOneReview(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.reviewService.read(id));
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody Review review) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.reviewService.update(id, review));
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.reviewService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        this.reviewService.deleteAll();
    }
}
