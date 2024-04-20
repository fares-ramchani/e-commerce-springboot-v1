package com.example.ecommerce.coucheservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.FileSystemResource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Transactional
@AllArgsConstructor
public class SendMailMessage {
    private final JavaMailSender javaMailSender;
    public void sendMailToClient(String toEmail, String body, String subject) throws MessagingException, jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("ayoubbahroun203@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);
        javaMailSender.send(mimeMessage);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerEmail() {

        System.out.println("Application Ready Event Triggered");
    }
}
