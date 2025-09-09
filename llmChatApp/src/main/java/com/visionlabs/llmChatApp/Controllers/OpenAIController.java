package com.visionlabs.llmChatApp.Controllers;

import com.visionlabs.llmChatApp.dtos.OpenAIDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/openai")
@CrossOrigin("*")
public class OpenAIController {

    private final ChatClient chatClient;
    public OpenAIController(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }


    @GetMapping("/message")
    public String response(@RequestBody OpenAIDTO openAIDTO){
        String input = openAIDTO.getPrompt();
        String response = chatClient.prompt(input).call().content();
        return response;
    }


}
