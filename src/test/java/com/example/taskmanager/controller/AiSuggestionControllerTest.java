package com.example.taskmanager.controller;

import com.example.taskmanager.dto.AiSuggestionRequest;
import com.example.taskmanager.dto.AiSuggestionResponse;
import com.example.taskmanager.service.AiSuggestionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AiSuggestionController.class)
class AiSuggestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AiSuggestionService aiSuggestionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnAiSuggestions() throws Exception {
        AiSuggestionRequest request = new AiSuggestionRequest();
        request.setTitle("Fix API Bug");

        AiSuggestionResponse response = AiSuggestionResponse.builder()
                .suggestion("Here is a suggestion for your task: Fix API Bug")
                .build();

        when(aiSuggestionService.generateSuggestion(request)).thenReturn(response);

        mockMvc.perform(post("/api/ai/suggest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.suggestion").exists());
    }
}
