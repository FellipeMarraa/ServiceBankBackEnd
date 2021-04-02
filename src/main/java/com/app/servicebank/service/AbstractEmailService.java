package com.app.servicebank.service;

import java.util.Date;

import com.app.servicebank.model.Cliente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

public  class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;


    //TODO IMPLEMENTAR O ENVIO DE EMAIL CONFIRMANDO QUE O BANCO RECEBEU A ANÁLISE DO USUÁRIO
    @Override
    public void sendOrderConfirmationEmail(Cliente cliente) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromCliente(cliente);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromCliente(Cliente obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação enviada! Código: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return sm;
    }

    @Override
    public void sendEmail(SimpleMailMessage msg) {

    }

    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
}
