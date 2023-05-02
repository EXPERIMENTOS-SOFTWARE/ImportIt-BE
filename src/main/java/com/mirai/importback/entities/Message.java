package com.mirai.importback.entities;

import java.time.LocalDateTime;

public class Message {
    private String from;
    private LocalDateTime time;
    private String messageContent;

    public Message(String from, LocalDateTime time, String messageContent) {
        this.from = from;
        this.time = time;
        this.messageContent = messageContent;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
