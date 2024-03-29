package com.app.servicebank.services;

import com.app.servicebank.dto.ClienteDTO;
import com.app.servicebank.dto.ClienteNewDTO;
import com.app.servicebank.model.Cliente;
import com.app.servicebank.repository.ClienteRepository;
import com.app.servicebank.services.exception.DataIntegrityException;
import com.app.servicebank.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;


    public Cliente find(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insert(Cliente cliente) {
        cliente.setId(null);
        cliente = repository.save(cliente);
        emailService.sendOrderConfirmationHtmlEmail(cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }


    public Cliente update(Cliente cliente) {
        Cliente newCliente = find(cliente.getId());
        updateData(newCliente, cliente);
        return repository.save(cliente);
    }


    public Void delete(Integer id) {
        try {
            repository.delete(find(id));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir o usuário");
        }

        return null;
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repository.findAll(pageRequest);

    }

    private void updateData(Cliente newCliente, Cliente cliente){

        newCliente.setNome(cliente.getNome());
        newCliente.setEmail(cliente.getEmail());
        newCliente.setSenha(cliente.getSenha());
    }


    public Cliente fromDTO(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), bCryptPasswordEncoder.encode(clienteDTO.getSenha()), null, null );
    }

    public Cliente fromDTO(ClienteNewDTO clienteNewDTO) {

         Cliente cliente = new Cliente(null, clienteNewDTO.getNome(), clienteNewDTO.getEmail(), bCryptPasswordEncoder.encode(clienteNewDTO.getSenha()), clienteNewDTO.getCpf(), clienteNewDTO.getCnpj());

        return cliente;

    }
}
