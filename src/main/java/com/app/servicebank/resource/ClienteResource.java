package com.app.servicebank.resource;

import com.app.servicebank.model.Cliente;
import com.app.servicebank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

@RequestMapping(method = RequestMethod.GET)
    public String listar(){

        return "REST FUNCIONANDO";

    }


}
