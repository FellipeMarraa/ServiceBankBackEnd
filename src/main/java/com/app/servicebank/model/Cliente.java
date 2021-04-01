package com.app.servicebank.model;

import com.app.servicebank.model.enums.TipoCliente;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message="Preenchimento obrigatório")
//    @Column(unique = true)
//    @CPF
    private String cpf;

    //TODO IMPLEMENTAR CNPJ NO FRONT
////    @CNPJ
//    private String cnpj;

//    @Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Email(message = "Email inválido")
//    @Column(unique = true)
    private String email;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String senha;

//    private Integer tipo;

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

//    public TipoCliente getTipo() {
//        return TipoCliente.toEnum(tipo);
//    }
//
//    public void setTipo(TipoCliente tipo) {
//        this.tipo = tipo.getCod();
//    }

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
}
