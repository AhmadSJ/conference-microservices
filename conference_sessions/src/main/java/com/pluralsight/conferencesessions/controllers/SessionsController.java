package com.pluralsight.conferencesessions.controllers;


import com.pluralsight.conferencesessions.exceptions.SessionsNotFoundException;
import com.pluralsight.conferencesessions.models.Session;
import com.pluralsight.conferencesessions.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/version1/sessions")
public class SessionsController {

    private SessionService sessionService;

    @Autowired
    public SessionsController(SessionService sessionService) {
        this.sessionService = sessionService;

    }

    @GetMapping("/sessionid/{id}")
    public ResponseEntity<Session> getSessionId(@PathVariable Long id) {
        Optional<Session> session = this.sessionService.findSession(id);
        if(session.isPresent()) {
            return new ResponseEntity(session.get(), HttpStatus.FOUND);
        } else throw new SessionsNotFoundException("Session " + id + " is not present");
    }


    @GetMapping//("/listsessions")
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> list = this.sessionService.listSessions();
        return new ResponseEntity<List<Session>>(list, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ResponseEntity<Session> get(@PathVariable Long id) {
        Optional<Session> session = this.sessionService.findSession(id);
        if (session.isPresent()) {
            return new ResponseEntity(session.get(), HttpStatus.OK);
        } else throw new SessionsNotFoundException("Session " + id + " is not present");
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
//
//        return fieldErrorMessages;
//    }


    @PostMapping
    public ResponseEntity<Session> create(@Valid @RequestBody Session session) {
        Session createdSession = this.sessionService.create(session);
        return new ResponseEntity<Session>(createdSession, HttpStatus.CREATED);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.sessionService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Session> update(@PathVariable Long id, @RequestBody Session session) {
        return new ResponseEntity(this.sessionService.update(id, session), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Session> patch(@PathVariable Long id, @RequestBody Session session) {
        return new ResponseEntity(this.sessionService.patch(id, session), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/search_name")
    public ResponseEntity<Session> findIt(@RequestParam String name) {
        System.out.println("find name: " + name);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(this.sessionService.findSessionName(name));
    }

    @DeleteMapping
    public void deleteAll() {
        this.sessionService.deleteAll();
    }

}
