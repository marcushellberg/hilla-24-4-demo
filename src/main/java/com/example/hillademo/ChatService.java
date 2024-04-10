package com.example.hillademo;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import reactor.core.publisher.Flux;

@BrowserCallable
@AnonymousAllowed
public class ChatService {

    private final ChatClient chatClient;
    private final StreamingChatClient streamingChatClient;


    public ChatService(ChatClient chatClient, StreamingChatClient streamingChatClient) {
        this.chatClient = chatClient;
        this.streamingChatClient = streamingChatClient;
    }

    public String getCompletion(String text) {
        return chatClient.call(text);
    }

    public Flux<String> getStreamingCompletion(String text) {
        return streamingChatClient.stream(text);
    }

}
