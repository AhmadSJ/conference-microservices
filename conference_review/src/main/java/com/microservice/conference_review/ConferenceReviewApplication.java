package com.microservice.conference_review;

import com.microservice.conference_review.models.Review;
import com.microservice.conference_review.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ConferenceReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceReviewApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ReviewRepository repository) {
        return (args) -> {
            repository.deleteAll();

            // save a couple of customers
            int n_data = 15;
            for (long i = 1L; i <= n_data; i++) {
                Long review_id = i;
                String name = "name_review" + i;
                String content = "content_review" + i;
                String author = "author_review" + i;
                String rating = "rating_review" + i;
                Review review = new Review(review_id, name, content, author, rating);
                if(i<11) {
                    review.setSessionId(i);
                    review.setName("name_Session_Review"+i);
                } else {
                    review.setSpeakerId(i);
                    review.setName("name_Speaker_Review"+i);
                }
                repository.save(review);
            }

            // fetch all customers
            System.out.println("Review found with findAll():");
            System.out.println("-------------------------------");
            for (Review review : repository.findAll()) {
                System.out.println(review);
            }
            System.out.println();

            // fetch an individual customer
            System.out.println("Review found with findById(3):");
            System.out.println("--------------------------------");
            System.out.println(repository.findById(3L));
        };
    }

}
