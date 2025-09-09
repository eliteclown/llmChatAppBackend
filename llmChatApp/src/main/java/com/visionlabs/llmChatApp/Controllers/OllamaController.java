package com.visionlabs.llmChatApp.Controllers;

import com.visionlabs.llmChatApp.dtos.OpenAIDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ollama")
public class OllamaController {
    private final ChatClient chatClient;
    public OllamaController(OllamaChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }


    @GetMapping("/message")
    public String response(@RequestBody OpenAIDTO openAIDTO){
        String input = openAIDTO.getPrompt();
        String response = chatClient.prompt(input).call().content();
        return response;
    }
}
