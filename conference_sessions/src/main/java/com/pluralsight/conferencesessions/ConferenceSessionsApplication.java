package com.pluralsight.conferencesessions;

import com.pluralsight.conferencesessions.models.Session;
import com.pluralsight.conferencesessions.repositories.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class ConferenceSessionsApplication {
    private static final Logger log = LoggerFactory.getLogger(ConferenceSessionsApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ConferenceSessionsApplication.class, args);
        System.out.println("Hello World");
    }

    @Bean
    public CommandLineRunner demo(SessionRepository sessionRepository) {
        return (args) -> {
            sessionRepository.save(new Session((Long) 1L, "Software Engineering Track Capgemini", "Microservices", "" +
                    "Microservices have become an essential part of application development in the past years. This session will describe the implementation of microservices" +
                    " and how they changed the software development cycle.", "Reykavikplein 1, Utrecht, Room 3A", "11-06-2021, 13:00"
                    ,"11-06-2021, 14:00", "18/20"));
            //Populate session table
            int n_data = 5;
            long n_speakers_in_session = 2L;
            List<Long> speakers;
            Long speaker_number = 1L;
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for(long i=2L; i<=n_data; i++) {
                speakers = new ArrayList<>();
                for(long j=1L; j<=n_speakers_in_session; j++){
                    speakers.add(speaker_number);
                    speaker_number++;
                }
                long random_speaker = random.nextLong(1,11);
                do {
                    if(!speakers.contains(random_speaker)){
                        speakers.add(random_speaker);
                    } else {
                        random_speaker = random.nextLong(1,11);
                    }

                } while(!speakers.contains(random_speaker));

                String name = "title_session" + i;
                String subject = "subject_session" +i;
                String description = "description_session" + i;
                String address = "address_session" + i;
                String start_date_time = "start_date_time_session" + i;
                String end_date_time = "end_date_time_session" + i;
                String max_participants = "max_participants_session" + i;
                sessionRepository.save(new Session((Long) i, name, subject, description, address, start_date_time
                ,end_date_time, max_participants, speakers));
            }
//            speakerRepository.save(new Speaker(1L, "Ahmad", "Jamalzada", "Spring Boot",
//                    "Studies physics and likes dogs"));
//            speakerRepository.save(new Speaker(2L, "Bob", "The Builder", "Construction",
//                    "Studied structural engineering and likes children"));
//            speakerRepository.save(new Speaker(3L, "Geralt", "Riverdale"));
//            //Populate session table
//            sessionRepository.save(new Session(10L, "Teaching Dogs the Theory of General Relativity", "Psychology of Dogs",
//                    "This session will discuss the possibility of teaching dogs about Einstein's spacetime", "Utrecht",
//                    "1 january 10:00", "1 january 11:00", "42"));
//            sessionRepository.save(new Session(11L, "Will this code work?", "compilation of code",
//                    "Checking whether this code will work or not", "Utrecht",
//                    "1 january 10:00", "1 january 11:00", "15"));
//            //Insert session_speakers relational table
//            //Retrieve each session by ID
//            Session dogsession = sessionRepository.findById(1L).get();
//            Session codesession = sessionRepository.findById(2L).get();
//            //Retrieve list of speakers speaking during the dogsession
//            List<Speaker> speakersdogsession = new ArrayList<Speaker>();
//            speakersdogsession.add(speakerRepository.findById(1L).get());
//            //Insert list of speakers into the session_id 10L a.k.a. "dogsession"
//            dogsession.setSpeakers(speakersdogsession);
//            sessionRepository.save(dogsession);
//
//            //Rertrieve list of speakers speaking during codesession
//            List<Speaker> speakerscodesession = new ArrayList<Speaker>();
//            speakerscodesession.add(speakerRepository.findById(2L).get());
//            speakerscodesession.add(speakerRepository.findById(3L).get());
//            //Insert list of speakers into the session_id 11L a.k.a. "codesession"
//            codesession.setSpeakers(speakerscodesession);
//            sessionRepository.save(codesession);
//
//            log.info("Speakers found with findAll():");
//            log.info("-------------------------------");
//            for (Speaker speaker : speakerRepository.findAll()) {
//                log.info(speaker.toString());
//            }
//            log.info("");
//
//            // fetch an individual session by ID
//            Speaker speaker = speakerRepository.findById(1L).get();
//            log.info("Speaker found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(speaker.toString());
//            log.info("");
//
//            log.info("Sessions found with findAll():");
//            log.info("-------------------------------");
//            for (Session session : sessionRepository.findAll()) {
//                log.info(session.toString());
//            }
//            log.info("");
//
//            // fetch an individual session by ID
//            Session session = sessionRepository.findById(1L).get();
//            log.info("Speaker found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(session.toString());
//            log.info("");
        };
    }

}
