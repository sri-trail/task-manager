package com.example.taskmanager.controller;

import com.example.taskmanager.dto.AiSuggestionRequest;
import com.example.taskmanager.dto.AiSuggestionResponse;
import com.example.taskmanager.service.AiSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiSuggestionController {

    private final AiSuggestionService aiSuggestionService;

    @PostMapping("/suggest")
    public AiSuggestionResponse suggest(@RequestBody AiSuggestionRequest request) {
        return aiSuggestionService.generateSuggestion(request);
    }
}
