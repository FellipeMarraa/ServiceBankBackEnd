package com.app.servicebank.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {

    private String cpf;

//    private String cnpj;

    private String senha;

    public CredenciaisDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
//
//    public String getCnpj() {
//        return cnpj;
//    }
//
//    public void setCnpj(String cnpj) {
//        this.cnpj = cnpj;
//    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
