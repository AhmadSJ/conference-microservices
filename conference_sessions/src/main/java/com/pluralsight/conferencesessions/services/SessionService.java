package com.pluralsight.conferencesessions.services;

import com.pluralsight.conferencesessions.models.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    Session create(Session session);
    Session read(Long id);
    Session update(Long id, Session session);
    void delete(Long id);
    Session patch(Long id, Session session);
    List<Session> listSessions();
    String[] copyNullPropertyNames(Object source);
    Optional<Session> findSession(Long id);
    Session findSessionName(String name);
    void deleteAll();
    Long findSessionId(Long id);
}

