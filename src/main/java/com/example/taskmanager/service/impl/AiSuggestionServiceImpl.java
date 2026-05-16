package com.example.taskmanager.service.impl;

import com.example.taskmanager.dto.AiSuggestionRequest;
import com.example.taskmanager.dto.AiSuggestionResponse;
import com.example.taskmanager.service.AiSuggestionService;
import org.springframework.stereotype.Service;

@Service
public class AiSuggestionServiceImpl implements AiSuggestionService {

    @Override
    public AiSuggestionResponse generateSuggestion(AiSuggestionRequest request) {

        String suggestion = "Here is a suggestion for your task: " +
                request.getTitle() +
                ". Try breaking it into smaller steps to stay productive.";

        return AiSuggestionResponse.builder()
                .suggestion(suggestion)
                .build();
    }
}
