package com.umarket.chat_service.controller;

import com.umarket.chat_service.Repository.ChatRepository;
import com.umarket.chat_service.model.Chat;
import com.umarket.chat_service.model.Message;
import com.umarket.chat_service.Repository.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    @PostMapping("/create")
    public Chat createChat(@RequestBody Chat chatRequest) {
        Chat newChat = new Chat();
        newChat.setBuyerId(chatRequest.getBuyerId());
        newChat.setSellerId(chatRequest.getSellerId());
        newChat.setProductId(chatRequest.getProductId());
        newChat.setDateCreation(LocalDateTime.now());

        // Guardar en la base de datos
        return chatRepository.save(newChat);
    }
    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/send")
    @SendTo("/tema/messages")
    public Message sendMessage(Message message) {
        System.out.println("Mensaje recibido: " + message);

        // Guardar mensaje en la base de datos
        /*Message savedMessage = messageRepository.save(new Message(
                message.getChatId(),
                message.getContent(),
                "unread",
                message.getUserId()
        ));*/

        return message;
    }
}