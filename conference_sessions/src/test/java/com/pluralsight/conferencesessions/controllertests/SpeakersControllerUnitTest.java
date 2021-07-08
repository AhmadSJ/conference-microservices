//package com.pluralsight.conferencedemoopdracht.controllertests;
//
//
//import com.pluralsight.conferencedemoopdracht.controllers.SpeakersController;
//import com.pluralsight.conferencedemoopdracht.services.SpeakerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest(SpeakersController.class)
//public class SpeakersControllerUnitTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    SpeakerService speakerService;
//
//    @Test
//    public void getAllSpeakersTest() throws Exception {
//        mockMvc.perform(get("/api/version1/speakerscontroller/"))
//                .andExpect(status().isOk());
//                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                //.andExpect(content().json("[]"));
//
//        verify(speakerService, times(1)).listSpeakers();
//    }
//
//}
