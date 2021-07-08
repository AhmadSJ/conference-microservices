package com.microservices.conference_speakers.services;

import com.microservices.conference_speakers.models.Speaker;
import com.microservices.conference_speakers.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository speakerRepository;

    @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public Speaker create(final Speaker speaker) {
        return this.speakerRepository.saveAndFlush(speaker);
    }

    public Speaker read(Long id) {
        return this.speakerRepository.findById(id).get();
    }

    public Speaker update(Long id, Speaker speaker) {
        Speaker existingSpeaker = this.speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return this.speakerRepository.saveAndFlush(existingSpeaker);
    }

    public void delete(Long id) {
        //Also need to check for children records before deleting.
        this.speakerRepository.deleteById(id);
    }

    public Speaker patch(Long id, Speaker speaker) {
        Speaker existingSpeaker = this.speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker, existingSpeaker, getNullPropertyNames(speaker));
        return this.speakerRepository.saveAndFlush(existingSpeaker);
    }

    public List<Speaker> listSpeakers() {
        return (List)this.speakerRepository.findAll();
    }

    public String[] getNullPropertyNames(Speaker source, String... args) {
        List<String> nullValuePropertyNames = new ArrayList<>();
        for (Field f : source.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                if (f.get(source) == null) {
                    nullValuePropertyNames.add(f.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (args.length >0) {
            for (String input : args) {
                nullValuePropertyNames.add(input);
            }
        }
        return nullValuePropertyNames.toArray(new String[0]);
    }

    public void deleteAll() {
        List<Speaker> speaker = this.speakerRepository.findAll();
        for(Speaker speak : speaker){
            this.speakerRepository.deleteById(speak.getSpeaker_id());
        }
    }
}
