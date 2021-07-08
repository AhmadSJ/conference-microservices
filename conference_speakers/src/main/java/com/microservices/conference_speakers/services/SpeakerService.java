package com.microservices.conference_speakers.services;

import com.microservices.conference_speakers.models.Speaker;

import java.util.List;

public interface SpeakerService {
    Speaker create(Speaker speaker);
    Speaker read(Long id);
    Speaker update(Long id, Speaker speaker);
    void delete(Long id);
    Speaker patch(Long id, Speaker speaker);
    List<Speaker> listSpeakers();
    String[] getNullPropertyNames(Speaker source, String... args);
    void deleteAll();
}
