package com.umarket.chat_service.Repository;

import com.umarket.chat_service.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}