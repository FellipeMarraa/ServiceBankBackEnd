package com.app.servicebank.service;

import com.app.servicebank.dto.BancoDTO;
import com.app.servicebank.dto.BancoNewDTO;
import com.app.servicebank.model.Banco;
import com.app.servicebank.repository.BancoRepository;
import com.app.servicebank.service.exception.DataIntegrityException;
import com.app.servicebank.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository repository;


    public Banco find(Integer id) {
        Optional<Banco> banco = repository.findById(id);
        return banco.orElseThrow(() -> new ObjectNotFoundException("Banco não encontrado! Id: " + id + ", Tipo: " + Banco.class.getName()));
    }

    @Transactional
    public Banco insert(Banco banco) {
        banco.setId(null);
        return repository.save(banco);
    }

    public List<Banco> findAll(){
        return repository.findAll();
    }


    public Banco update(Banco banco) {
        Banco newBanco = find(banco.getId());
        updateData(newBanco, banco);
        return repository.save(newBanco);
    }


    public Void delete(Integer id) {
        try {
            repository.delete(find(id));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir o banco");
        }

        return null;
    }

    public Page<Banco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repository.findAll(pageRequest);

    }

    private void updateData(Banco newBanco, Banco banco){

        newBanco.setNome(banco.getNome());
    }


    public Banco fromDTO(BancoDTO bancoDTO) {
        return new Banco(bancoDTO.getId(), bancoDTO.getNome());
    }

    public Banco fromDTO(BancoNewDTO bancoNewDTO) {

         Banco banco = new Banco(null, bancoNewDTO.getNome());

        return banco;

    }
}
