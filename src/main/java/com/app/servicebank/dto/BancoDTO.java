package com.app.servicebank.dto;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.service.validation.BancoUpdate;

import java.io.Serializable;

@BancoUpdate
public class BancoDTO implements Serializable {

    private Integer id;

    private String nome;

    public BancoDTO() {
    }

    public BancoDTO(Cliente clienteDto) {
        id = clienteDto.getId();
        nome = clienteDto.getNome();

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

}
