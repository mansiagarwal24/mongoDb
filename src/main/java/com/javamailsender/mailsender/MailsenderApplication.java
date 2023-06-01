package com.javamailsender.mailsender;

import com.javamailsender.mailsender.repository.EmailRepository;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableRabbit
@EnableMongoRepositories
public class MailsenderApplication {
	public static void main(String[] args) {
		SpringApplication.run(MailsenderApplication.class, args);
	}

}
