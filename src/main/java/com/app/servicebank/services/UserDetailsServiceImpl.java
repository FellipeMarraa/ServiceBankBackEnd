package com.app.servicebank.services;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.repository.ClienteRepository;
import com.app.servicebank.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;



    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null){
            throw new UsernameNotFoundException(cpf);
        }
        return new UserSS(cliente.getId(), cliente.getCpf(), cliente.getSenha());
    }

}
