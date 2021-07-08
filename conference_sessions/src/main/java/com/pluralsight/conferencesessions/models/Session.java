package com.pluralsight.conferencesessions.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 6, message = "Name should have atleast 2 characters")
    private String name;
    //@NotEmpty(message = "subject must not be empty")
    private String subject;
    private String description;
    private String address;
    private String start_date_time;
    private String end_date_time;
    private String max_participants;
    @ElementCollection
    private List<Long> speaker_ids;

    public List<Long> getSpeaker_ids() {
        return speaker_ids;
    }

    public void setSpeaker_ids(List<Long> speaker_ids) {
        this.speaker_ids = speaker_ids;
    }

    public Session() {

    }

    public Session(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public Session(Long session_id, String name, String subject, String description, String address, String start_date_time, String end_date_time, String max_participants) {
        this.session_id = session_id;
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.address = address;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.max_participants = max_participants;
    }

    public Session(Long session_id, String name, String subject, String description, String address, String start_date_time, String end_date_time, String max_participants, List<Long> speaker_ids) {
        this.session_id = session_id;
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.address = address;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.max_participants = max_participants;
        this.speaker_ids = speaker_ids;
    }

    @Override
    public String toString() {
        return String.format(
                "Session[id=%d, name='%s', subject='%s', description='%s', address='%s', start_date_time='%s', " +
                        "end_date_time='%s', max_participants='%s', speaker_ids='%s']",
                this.session_id, this.name, this.subject, this.description, this.address, this.start_date_time,
                this.end_date_time, this.max_participants);
    }


    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(String start_date_time) {
        this.start_date_time = start_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    public String getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(String max_participants) {
        this.max_participants = max_participants;
    }
}
