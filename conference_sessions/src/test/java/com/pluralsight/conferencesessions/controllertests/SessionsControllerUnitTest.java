//package com.pluralsight.conferencedemoopdracht.controllertests;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pluralsight.conferencedemoopdracht.controllers.SessionsController;
//import com.pluralsight.conferencedemoopdracht.models.Session;
//import com.pluralsight.conferencedemoopdracht.services.SessionService;
//import com.pluralsight.conferencedemoopdracht.services.SpeakerService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.MockBeans;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(SessionsController.class)
//@MockBeans({@MockBean(SessionService.class)})
//public class SessionsControllerUnitTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private SessionService sessionService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void getAllSessions() throws Exception {
//        mockMvc.perform(get("/api/version1/sessionscontroller"))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(content().json("[]"));
//
//        verify(sessionService, times(1)).listSessions();
//    }
//
//    @Test
//    public void testCreateReadDelete() {
//        Session session = new Session("Spring Boot Testing", "Implementing Tests in Spring Boot");
//
//        sessionService.create(session);
//        Iterable<Session> sessions = sessionService.listSessions();
//        Assertions.assertThat(sessionService.listSessions()).isEmpty();
//    }
//}
