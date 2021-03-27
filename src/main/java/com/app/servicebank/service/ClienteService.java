package com.app.servicebank.service;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    @Transactional
    public Cliente insert(Cliente cliente) {
        cliente = repository.save(cliente);
        return cliente;
    }

    public Cliente find(Integer id){

        Optional<Cliente> clienteOptional = repository.findById(id);
        return  clienteOptional.orElse(null);
    }


}
