package com.javamailsender.mailsender.controller;

import com.javamailsender.mailsender.model.EmailSender;
import com.javamailsender.mailsender.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;
    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailSender emailSender){
        emailService.sendEmail(emailSender);
        return "Email sent Successfully!!";
    }

    @PostMapping("/send-email-with-attachment")
    public String sendEmailWithAttachment(@RequestBody EmailSender emailSender) throws MessagingException {
        emailService.sendEmailWithAttachment(emailSender);
        return "Email sent Successfully!!";
    }
}
