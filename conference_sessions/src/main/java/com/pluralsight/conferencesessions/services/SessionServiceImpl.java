package com.pluralsight.conferencesessions.services;

import com.pluralsight.conferencesessions.exceptions.SessionsNotFoundException;
import com.pluralsight.conferencesessions.models.Session;
import com.pluralsight.conferencesessions.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SessionServiceImpl implements SessionService{

    private SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session create(Session session) {
        return this.sessionRepository.saveAndFlush(session);
    }

//    public Session read(Long id) {
//        return sessionRepository.getOne(id);
//    }

    public Long findSessionId(Long id) {
        return this.sessionRepository.findById(id).get().getSession_id();
    }

    public Optional<Session> findSession(Long id) {
        return this.sessionRepository.findById(id);
    }

    public Session update(Long id, Session session) {
        Session existingSession = this.sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return this.sessionRepository.saveAndFlush(existingSession);
    }

    public void delete(Long id) {
        //Also need to check for children records before deleting.
        this.sessionRepository.deleteById(id);
    }

    public Session patch(Long id, Session session) {
        Session existingSession = this.sessionRepository.findById(id).get();
        BeanUtils.copyProperties(session, existingSession, copyNullPropertyNames(session));
        //existingSession = copyNonNullProperties(session, existingSession);
        return this.sessionRepository.saveAndFlush(existingSession);
    }

    public List<Session> listSessions() {
        return (List)this.sessionRepository.findAll();
    }

    public String[] copyNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

//    public String[] getNullPropertyNames(Session source, String... args) {
//        List<String> nullValuePropertyNames = new ArrayList<>();
//        for (Field f : source.getClass().getDeclaredFields()) {
//            //System.out.println("field f: " + f);
//            try {
//                f.setAccessible(true);
//                if (f.get(source) == null) {
//                    nullValuePropertyNames.add(f.getName());
//                    //System.out.println("null fields: " + f.getName());
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return nullValuePropertyNames.toArray(new String[0]);
//    }

    public Session read(Long id) {
//        Optional<Session> optionalSession = this.sessionRepository.findById(id);
//        if (optionalSession.isPresent()) {
//            return optionalSession.get();
//        } else {
//            throw new SessionsNotFoundException("Session " + id + " is niet te vinden, probeer ALT+F4");
//        }
        return this.sessionRepository.findById(id).orElseThrow(() -> new SessionsNotFoundException("Session " + id + " is niet te vinden, probeer ALT+F4"));
    }

    public Session findSessionName(String name) {
        return this.sessionRepository.findByName(name);
    }

    public void deleteAll() {
        List<Session> session = this.sessionRepository.findAll();
        for(Session ses : session){
            this.sessionRepository.deleteById(ses.getSession_id());
        }
    }
}
