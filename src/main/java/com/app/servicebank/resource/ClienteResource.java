package com.app.servicebank.resource;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public Cliente getById(@PathVariable Integer id) {
        return service.find(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Cliente> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Cliente insert(@Valid @RequestBody Cliente cliente) {
        return service.insert(cliente);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public Cliente update(@Valid @RequestBody Cliente cliente, @PathVariable Integer id) {
        cliente.setId(id);
        return service.update(cliente);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Cliente logar(@RequestBody Cliente cliente) {
        return service.logar(cliente);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Cliente> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);

        return list;
    }


}
