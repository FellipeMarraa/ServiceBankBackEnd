package com.app.servicebank.resource;

import com.app.servicebank.dto.BancoDTO;
import com.app.servicebank.dto.BancoNewDTO;
import com.app.servicebank.model.Banco;
import com.app.servicebank.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/banco")
public class BancoResource {

    @Autowired
    private BancoService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Banco getById(@PathVariable Integer id) {
        return service.find(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Banco> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<Banco> insert(@Valid @RequestBody BancoNewDTO bancoNewDTO) {
        Banco banco = service.fromDTO(bancoNewDTO);
        banco = service.insert(banco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(banco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Banco> update(@Valid @RequestBody BancoDTO bancoDTO, @PathVariable Integer id) {
        Banco banco = service.fromDTO(bancoDTO);
        banco.setId(id);
        banco = service.update(banco);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Banco> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Banco> list = service.findPage(page, linesPerPage, orderBy, direction);

        return list;
    }


}
