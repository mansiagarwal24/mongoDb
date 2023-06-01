package com.javamailsender.mailsender.repository;

import com.javamailsender.mailsender.model.EmailSender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<EmailSender,String> {
}
