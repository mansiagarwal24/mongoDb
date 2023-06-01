package com.javamailsender.mailsender.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamailsender.mailsender.model.EmailSender;
import com.javamailsender.mailsender.repository.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailConsumer {
    @Autowired
    EmailRepository emailRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "direct.queue")
    public void processEmail(Message message) throws IOException {
        log.info(message.toString());
        EmailSender emailSender = objectMapper.readValue(message.getBody(), EmailSender.class);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mansi.aggarwal@tothenew.com");
        simpleMailMessage.setTo(emailSender.getToEmail());
        simpleMailMessage.setSubject(emailSender.getSubject());
        simpleMailMessage.setText(emailSender.getBody());
        emailRepository.save(emailSender);
        javaMailSender.send(simpleMailMessage);


//        MimeMessage message1 = javaMailSender.createMimeMessage();
//        MimeMessageHelper messageHelper = new MimeMessageHelper(message1,true);
//
//        messageHelper.setFrom("mansi.aggarwal@tothenew.com");
//        messageHelper.setTo(emailSender.getToEmail());
//        messageHelper.setSubject(emailSender.getSubject());
//        messageHelper.setText(emailSender.getBody());
//
//        FileSystemResource file=new FileSystemResource(new File(emailSender.getAttachment()));
//        messageHelper.addAttachment(file.getFilename(), file);
//        javaMailSender.send(message1);
    }
}
