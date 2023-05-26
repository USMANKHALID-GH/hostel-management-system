package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.model.Messages;
import com.usman.hostelmanagementsystem.repository.MessageRepository;
import com.usman.hostelmanagementsystem.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    @Autowired
    private final MessageRepository messageRepository;

    public  void sendMessage(@Lazy Messages message){
        messageRepository.save(message);
    }
}
