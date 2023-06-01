package com.javamailsender.mailsender.service;

import com.javamailsender.mailsender.model.EmailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    DirectExchange directExchange;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail (EmailSender emailSender){
        rabbitTemplate.convertAndSend(directExchange.getName(),"direct.routingKey",emailSender);
    }

    public void sendEmailWithAttachment(EmailSender sender) throws MessagingException {
        rabbitTemplate.convertAndSend(directExchange.getName(),"direct.routingKey",sender);
    }
}
