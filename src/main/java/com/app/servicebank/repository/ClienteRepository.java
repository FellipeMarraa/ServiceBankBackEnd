package com.app.servicebank.repository;

import com.app.servicebank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);

    @Transactional(readOnly = true)
    Cliente findByCpf(String cpf);

    @Transactional(readOnly = true)
    Cliente findByCnpj(String cnpj);

}
