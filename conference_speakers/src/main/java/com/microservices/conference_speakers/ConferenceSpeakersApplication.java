package com.microservices.conference_speakers;

import com.microservices.conference_speakers.models.Speaker;
import com.microservices.conference_speakers.repositories.SpeakerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConferenceSpeakersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceSpeakersApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(SpeakerRepository repository) {
        return (args) -> {
            // save a couple of customers
            int n_data = 10;
            for (long i = 1L; i < n_data; i++) {
                Long speaker_id = i;
                String first_name = "first_name_speaker" + i;
                String last_name = "last_name_speaker" + i;
                String specialization = "specialization_speaker" + i;
                String bio = "bio_speaker" + i;
                repository.save(new Speaker(speaker_id, first_name, last_name, specialization, bio));
            }

            // fetch all speakers
            System.out.println("Speaker found with findAll():");
            System.out.println("-------------------------------");
            for (Speaker speaker : repository.findAll()) {
                System.out.println(speaker);
            }
            System.out.println();

            // fetch an individual speaker
            System.out.println("Speaker found with findById(3):");
            System.out.println("--------------------------------");
            System.out.println(repository.findById(3L));
        };
    }
}
