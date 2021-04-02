package com.app.servicebank.services.validation;

import com.app.servicebank.dto.BancoDTO;
import com.app.servicebank.model.Banco;
import com.app.servicebank.repository.BancoRepository;
import com.app.servicebank.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BancoUpdateValidation implements ConstraintValidator<BancoUpdate, BancoDTO> {

    @Autowired
    private BancoRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(BancoUpdate bancoUpdate) {

    }

    @Override
    public boolean isValid(BancoDTO bancoDTO, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

//
        Banco verificaEmail = repository.findByNome(bancoDTO.getNome());
        if (verificaEmail != null && !verificaEmail.equals(uriId)) {
            list.add(new FieldMessage("nome", "Banco já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


        return list.isEmpty();
    }

}
