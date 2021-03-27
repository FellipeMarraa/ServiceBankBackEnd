package com.app.servicebank.repository;

import com.app.servicebank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {



}
