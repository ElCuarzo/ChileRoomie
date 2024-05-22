package com.chileroomie.chileroomieapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail(String to, String subject, String verificationLink) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setFrom("chileroomies@outlook.com");
            helper.setSubject("Verificacion ChileRoomie");
            String htmlContent = "<html><body>" +
                                "<p> Hola, </p>" +
                                "<p> Por favor, haga click en el siguiente link para verificar su cuenta: </p>" +
                                "<a href='http://localhost:8080'>" + "Haz clic aquí</a>" +
                                "<p> Gracias, </p>" +
                                "<p> ChileRoomie </p>" +
                                "<img src='https://preview.redd.it/because-of-how-the-fortnite-multiverse-works-jonesy-is-v0-y0833tllfqhb1.jpg?width=640&crop=smart&auto=webp&s=47b7e63755fe35fefe30d8256cd1dc765d6726e5'/>" +
                                "</body></html>";
            helper.setText(htmlContent, true);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
