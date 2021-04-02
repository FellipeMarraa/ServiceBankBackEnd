package com.app.servicebank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String cnpj;

    private String nome;

    private String email;

    private String senha;


    public Cliente() {
    }

    public Cliente(Integer id,
                   String cpf,
                   String cnpj,
                   String nome,
                   String email,
                   String senha
    ) {
        this.id = id;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
