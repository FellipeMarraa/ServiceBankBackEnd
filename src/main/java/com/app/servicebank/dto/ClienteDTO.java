package com.app.servicebank.dto;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.model.enums.TipoCliente;
import com.app.servicebank.service.validation.ClienteUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {

    private Integer id;

    private String nome;

    private String cpf;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente clienteDto) {
        id = clienteDto.getId();
        nome = clienteDto.getNome();
        cpf = clienteDto.getEmail();
        senha = clienteDto.getSenha();

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

}
