package com.spring.ai.firstproject;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatControlller {
    private ChatClient chatClient;

    public ChatControlller(ChatClient.Builder builder){
        this.chatClient = builder.build();
   }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value ="q") String message){

       var resultResponse = chatClient
               .prompt(message)
               .call()
               .content();
        return ResponseEntity.ok(resultResponse);
    }
}
