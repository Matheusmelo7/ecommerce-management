package br.com.ecommercemanagement.service.costumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String companyAddress;

    public void sendPasswordRecoveryEmail(String email, String newPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyAddress);
        message.setTo(email);
        message.setSubject("Sua nova senha");
        message.setText("Sua nova senha é: " + newPassword + "\nPor favor, altere-a assim que possível.");
        emailSender.send(message);
    }
}
