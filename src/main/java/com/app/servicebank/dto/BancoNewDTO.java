package com.app.servicebank.dto;

import com.app.servicebank.services.validation.BancoInsert;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@BancoInsert
public class BancoNewDTO implements Serializable {

    @NotEmpty(message = "Preenchimento obrigatório")
    private String nome;


    public BancoNewDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
