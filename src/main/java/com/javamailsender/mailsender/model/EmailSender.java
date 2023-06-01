package com.javamailsender.mailsender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("email")
public class EmailSender {
    @Id
    private String id;
    private String toEmail;
    private String subject;
    private String body;
    private String attachment;
    private LocalDate dateCreated;
}
