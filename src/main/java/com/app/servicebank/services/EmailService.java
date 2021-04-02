package com.app.servicebank.services;

import javax.mail.internet.MimeMessage;

import com.app.servicebank.model.Cliente;
import org.springframework.mail.SimpleMailMessage;


public interface EmailService {

    void sendOrderConfirmationEmail(Cliente obj);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Cliente obj);

    void sendHtmlEmail(MimeMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
