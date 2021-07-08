package com.pluralsight.conferencesessions.repositories;

import com.pluralsight.conferencesessions.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    //Session findById(long id);
    Session findByName(String name);
}
