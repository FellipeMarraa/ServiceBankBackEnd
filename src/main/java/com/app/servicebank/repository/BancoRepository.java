package com.app.servicebank.repository;

import com.app.servicebank.model.Banco;
import com.app.servicebank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

    @Transactional(readOnly = true)
    Banco findByNome(String nome);

}
