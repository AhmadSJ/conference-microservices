package com.microservices.conference_speakers.controllers;

import com.microservices.conference_speakers.models.Speaker;
import com.microservices.conference_speakers.services.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/version1/speakers")
public class SpeakersController {
    private SpeakerService speakerService;

    @Autowired
    public void setSpeakerService(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }
    /*    @GetMapping("/speakers")
        public List<Speaker> list() {
            return this.speakerService.listSpeakers();
        }*/
    @GetMapping//("/listspeakers")
    public ResponseEntity<List<Speaker>> getAllSpeakers() {
        List<Speaker> list = this.speakerService.listSpeakers();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Speaker> get(@PathVariable Long id) {
        return new ResponseEntity(speakerService.read(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Speaker> create(@RequestBody Speaker speaker) {
        Speaker createdSpeaker = this.speakerService.create(speaker);
        return new ResponseEntity(createdSpeaker, HttpStatus.CREATED);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.speakerService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Speaker> update(@PathVariable Long id, @RequestBody Speaker speaker) {
        return new ResponseEntity(this.speakerService.update(id, speaker), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Speaker> patch(@PathVariable Long id, @RequestBody Speaker session) {
        return new ResponseEntity(this.speakerService.patch(id, session), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteAll() {
        this.speakerService.deleteAll();
    }

}