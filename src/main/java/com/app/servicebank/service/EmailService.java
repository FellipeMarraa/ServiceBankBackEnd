package com.app.servicebank.service;

import com.app.servicebank.model.Cliente;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Cliente obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
