package com.mirai.importback.services.impl;

import com.mirai.importback.entities.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MessagingService {

    private ArrayList<Message> messages;

    public MessagingService() {
        this.messages = new ArrayList<Message>();
    }

    public void sendMessage(String from, String messageContent) {
        Message message = new Message(from, LocalDateTime.now(), messageContent);
        this.messages.add(message);
    }

    public void sendMessage(Message message) {
        this.messages.add(message);
    }

    public Message filterMessageByContent(String content) {
        for (Message message : this.messages) {
            if (message.getMessageContent().contains(content)) {
                return message;
            }
        }
        return null;
    }

    public ArrayList<Message> filterMessagesByName(String name) {
        ArrayList<Message> filteredMessages = new ArrayList<Message>();
        for (Message message : this.messages) {
            if (message.getFrom().contains(name)) {
                filteredMessages.add(message);
            }
        }
        return filteredMessages;
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }
}
