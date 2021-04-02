package com.app.servicebank.services.validation;

import com.app.servicebank.dto.BancoNewDTO;
import com.app.servicebank.model.Banco;
import com.app.servicebank.repository.BancoRepository;
import com.app.servicebank.resources.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class BancoInsertValidation implements ConstraintValidator<BancoInsert, BancoNewDTO> {

    @Autowired
    private BancoRepository repository;

    @Override
    public void initialize(BancoInsert bancoInsert) {

    }

    @Override
    public boolean isValid(BancoNewDTO bancoNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Banco verificaNome = repository.findByNome(bancoNewDTO.getNome());
        if (verificaNome != null) {
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
