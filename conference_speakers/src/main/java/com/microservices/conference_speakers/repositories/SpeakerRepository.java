package com.microservices.conference_speakers.repositories;

import com.microservices.conference_speakers.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    //Speaker findById(long id);

}
