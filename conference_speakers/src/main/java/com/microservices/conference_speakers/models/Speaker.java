package com.microservices.conference_speakers.models;

import javax.persistence.*;

@Entity
@Table(name="speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;

    private String first_name;

    private String last_name;
    private String specialization;
    private String bio;

    public Speaker(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Speaker(Long speaker_id, String first_name, String last_name, String specialization, String bio) {
        this.speaker_id = speaker_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.specialization = specialization;
        this.bio = bio;
    }

    public Speaker(Long speaker_id, String first_name, String last_name) {
        this.speaker_id = speaker_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Speaker() {

    }

    @Override
    public String toString() {
        return String.format(
                "Speaker[id=%d, first_name='%s', last_name='%s', specialization='%s', bio='%s']",
                this.speaker_id, this.first_name, this.last_name, this.specialization, this.bio);
    }


    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
