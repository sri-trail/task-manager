package com.example.taskmanager.service;

import com.example.taskmanager.dto.AiSuggestionRequest;
import com.example.taskmanager.dto.AiSuggestionResponse;

public interface AiSuggestionService {
    AiSuggestionResponse generateSuggestion(AiSuggestionRequest request);
}
