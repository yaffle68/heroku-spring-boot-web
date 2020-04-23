package com.heroku.demo.service.internal;

import com.heroku.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendMail(String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("yaffle68@gmail.com");
        message.setSubject(name + " est au travail!");
        message.setText(name + " a commencé à " + LocalDateTime.now());
        emailSender.send(message);
    }
}
