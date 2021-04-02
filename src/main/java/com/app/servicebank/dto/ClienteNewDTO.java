package com.app.servicebank.dto;

import com.app.servicebank.services.validation.ClienteInsert;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteInsert
public class ClienteNewDTO implements Serializable {

    @Length(max = 11, message = "CPF deve conter 11 dígitos")
    @CPF
    private String cpf;

    @Length(max = 14, message = "CNPJ deve conter 14 dígitos")
    @CNPJ
    private String cnpj;

    @Length(min = 5, max = 120, message = ("O nome deve conter no mínimo 5 e no máximo 120 caracteres"))
    @NotEmpty(message = "Preenchimento obrigatório")
    private String nome;

    @Email
    @NotEmpty(message = "Email obrigatório")
    private String email;

    @Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;

    public ClienteNewDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
