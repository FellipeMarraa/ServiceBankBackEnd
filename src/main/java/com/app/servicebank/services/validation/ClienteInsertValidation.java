package com.app.servicebank.services.validation;

import com.app.servicebank.dto.ClienteNewDTO;
import com.app.servicebank.model.Cliente;
import com.app.servicebank.repository.ClienteRepository;
import com.app.servicebank.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidation implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteInsert clienteInsert) {

    }

    @Override
    public boolean isValid(ClienteNewDTO clienteNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

//        if (cliente.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(cliente.getCpf())) {
//            list.add(new FieldMessage("cpf", "CPF Inválido"));
//        }
////
////        if (cliente.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(cliente.getCnpj())){
////            list.add(new FieldMessage("cnpj", "CNPJ Inválido"));
////        }
//
//        Cliente verificaEmail = repository.findByEmail(clienteNewDTO.getEmail());
//        if (verificaEmail != null) {
//            list.add(new FieldMessage("email", "Email já cadastrado!"));
//        }
////
        Cliente verificaCpf = repository.findByCpf(clienteNewDTO.getCpf());
        if (verificaCpf != null) {
            list.add(new FieldMessage("cpf", "CPF já cadastrado!"));
        }
//
        Cliente verificaCnpj = repository.findByCnpj(clienteNewDTO.getCnpj());
        if (verificaCnpj != null) {
            list.add(new FieldMessage("cnpj", "CNPJ já cadastrado!"));
        }
//
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


            return list.isEmpty();
        }

}
