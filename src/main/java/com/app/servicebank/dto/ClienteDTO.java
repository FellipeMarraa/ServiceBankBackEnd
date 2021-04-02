package com.app.servicebank.dto;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.services.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {

    private Integer id;

    @Length(min = 5, max = 120, message = "O nome deve conter entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;

    @Email(message = "Email inválido")
    private String email;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente clienteDto) {
        id = clienteDto.getId();
        nome = clienteDto.getNome();
        senha = clienteDto.getSenha();
        email = clienteDto.getEmail();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
