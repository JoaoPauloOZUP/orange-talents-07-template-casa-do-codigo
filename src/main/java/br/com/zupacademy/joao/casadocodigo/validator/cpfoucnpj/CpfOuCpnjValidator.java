package br.com.zupacademy.joao.casadocodigo.validator.cpfoucnpj;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.ClienteRequest;
import br.com.zupacademy.joao.casadocodigo.model.Cliente;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfOuCpnjValidator implements ConstraintValidator<CpfCnjValue, String> {

    @Override
    public void initialize(CpfCnjValue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length() == 11 || value.length() == 14) {
            return true;
        }

        return false;
    }
}
