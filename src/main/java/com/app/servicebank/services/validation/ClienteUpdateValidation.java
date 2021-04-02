package com.app.servicebank.services.validation;

import com.app.servicebank.dto.ClienteDTO;
import com.app.servicebank.model.Cliente;
import com.app.servicebank.repository.ClienteRepository;
import com.app.servicebank.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidation implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(ClienteUpdate clienteUpdate) {

    }

    @Override
    public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();


        Cliente verificaEmail = repository.findByEmail(clienteDTO.getEmail());
        if (verificaEmail != null && !verificaEmail.getId().equals(uriId)) {
            list.add(new FieldMessage("email", "Email já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


        return list.isEmpty();
    }

}
