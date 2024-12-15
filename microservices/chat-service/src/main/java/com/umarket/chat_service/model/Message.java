package com.umarket.chat_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(nullable = false)
    private Long chatId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime dateSend;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long userId;

    public Message(Long chatId, String content, String status, Long userId) {
        this.chatId = chatId;
        this.content = content;
        this.status = status;
        this.userId = userId;
    }
}