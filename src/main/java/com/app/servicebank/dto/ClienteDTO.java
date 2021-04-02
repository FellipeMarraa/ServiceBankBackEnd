package com.app.servicebank.dto;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.services.validation.ClienteUpdate;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {

    private Integer id;

    private String nome;

    private String cpf;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;

    private String email;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente clienteDto) {
        id = clienteDto.getId();
        nome = clienteDto.getNome();
        cpf = clienteDto.getEmail();
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

    public String getEmail() {
        return cpf;
    }

    public void setEmail(String email) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
