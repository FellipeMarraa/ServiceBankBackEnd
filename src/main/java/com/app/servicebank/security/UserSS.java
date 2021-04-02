package com.app.servicebank.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserSS implements UserDetails {

    private Integer id;

    private String cpf;

//    private String cnpj;

    private String senha;

    private Collection<? extends GrantedAuthority> getAuthorities;

    public UserSS() {
    }

    public UserSS(Integer id, String cpf, String senha) {
        this.id = id;
        this.cpf = cpf;
//        this.cnpj = cnpj;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
