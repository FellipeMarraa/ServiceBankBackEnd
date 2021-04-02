package com.app.servicebank.dto;

import com.app.servicebank.model.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CpfDTO implements Serializable {

    @NotEmpty(message="Preenchimento obrigatório")
    @CPF
    private String cpf;

    private Cliente cliente;


    public CpfDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
