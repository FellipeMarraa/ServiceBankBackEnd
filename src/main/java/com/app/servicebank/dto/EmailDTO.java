package com.app.servicebank.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

public class EmailDTO implements Serializable {

    @Email(message="Email inválido")
    private String email;

    public EmailDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
