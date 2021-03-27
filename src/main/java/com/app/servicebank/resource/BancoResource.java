package com.app.servicebank.resource;

import com.app.servicebank.model.Banco;
import com.app.servicebank.model.Banco;
import com.app.servicebank.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/banco")
public class BancoResource {

    @Autowired
    private BancoService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Banco> findAll(@PathVariable Integer id) {
        Banco banco = service.find(id);
        return ResponseEntity.ok().body(banco);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Banco> find(@RequestBody Integer id) {
        Banco banco = service.find(id);
        return ResponseEntity.ok().body(banco);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Banco banco) {
        banco = service.insert(banco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(banco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Banco banco, @PathVariable Integer id) {
        banco.setId(id);
        banco = service.update(banco);
        return ResponseEntity.noContent().build();
    }


}
