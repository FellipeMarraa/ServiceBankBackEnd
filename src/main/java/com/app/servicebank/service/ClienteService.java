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
    public Cliente find(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElse(null);

    }

    @Transactional
    public Cliente insert(Cliente cliente) {
        cliente.setId(null);
        return repository.save(cliente);
    }
//    @Transactional
//    public List<Cliente> findAll(){
//        return repository.findAll();
//    }


    @Transactional
    public Cliente update(Cliente cliente) {
        find(cliente.getId());
        return repository.save(cliente);
    }


    public void delete(Integer id) {
        repository.delete(find(id));

    }

    public Cliente logar(Cliente cliente) {

        List<Cliente> listaDb = repository.findAll();

        List<Cliente> usuarios = listaDb.stream().filter(item -> item.getEmail().equals(cliente.getEmail()) && item.getSenha().equals(cliente.getSenha())).collect(Collectors.toList());

        if (usuarios != null) {
            return usuarios.get(0);
        }

        return cliente;
    }
}
