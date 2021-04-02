package com.app.servicebank.resources;

import com.app.servicebank.dto.ClienteDTO;
import com.app.servicebank.dto.ClienteNewDTO;
import com.app.servicebank.model.Cliente;
import com.app.servicebank.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<Cliente> insert(@Valid @RequestBody ClienteNewDTO clienteNewDTO) {
        Cliente cliente = service.fromDTO(clienteNewDTO);
        cliente = service.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
        Cliente cliente = service.fromDTO(clienteDTO);
        cliente.setId(id);
        cliente = service.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
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
