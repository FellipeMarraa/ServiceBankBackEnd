package com.app.servicebank.service;

import com.app.servicebank.model.Banco;
import com.app.servicebank.model.Cliente;
import com.app.servicebank.repository.BancoRepository;
import com.app.servicebank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository repository;


    @Transactional
    public Banco insert(Banco banco) {
        banco.setId(null);
        return repository.save(banco);
    }

    public Banco find(Integer id){
        Optional<Banco> banco = repository.findById(id);
        return banco.orElse(null);

    }


    public Banco update(Banco banco) {
        find(banco.getId());
        return repository.save(banco);
    }
}
