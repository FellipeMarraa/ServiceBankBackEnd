package com.app.servicebank.resource;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente cliente = service.find(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Cliente> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
        cliente = service.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
        cliente.setId(id);
        cliente = service.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Cliente logar(@RequestBody Cliente cliente) {
        return service.logar(cliente);
    }


}
