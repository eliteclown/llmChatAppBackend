package com.visionlabs.llmChatApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


public class OpenAIDTO {
    private String prompt;
    public String getPrompt() {
        return prompt;
    }


}
