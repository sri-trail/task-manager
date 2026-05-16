package com.example.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AiSuggestionResponse {
    private String suggestion;
}
