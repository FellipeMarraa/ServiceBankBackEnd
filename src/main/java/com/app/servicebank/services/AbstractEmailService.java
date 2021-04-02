package com.app.servicebank.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.app.servicebank.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendOrderConfirmationEmail(Cliente cliente) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromCliente(cliente);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromCliente(Cliente cliente) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Cliente cadastrado! ID: " + cliente.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(cliente.toString());
        return sm;
    }

    protected String htmlFromTemplateCliente(Cliente cliente) {
        Context context = new Context();
        context.setVariable("cliente", cliente);
        return templateEngine.process("email/confirmacaoCadastro", context);
    }

    @Override
    public void sendOrderConfirmationHtmlEmail(Cliente cliente) {
        try {
            MimeMessage mm = prepareMimeMessageFromCliente(cliente);
            sendHtmlEmail(mm);
        }
        catch (MessagingException e) {
            sendOrderConfirmationEmail(cliente);
        }
    }

    protected MimeMessage prepareMimeMessageFromCliente(Cliente cliente) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(cliente.getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Cliente cadastrado! ID: " + cliente.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateCliente(cliente), true);
        return mimeMessage;
    }
}
