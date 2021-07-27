package br.com.zupacademy.joao.casadocodigo.validator.email;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.AutorRequest;
import br.com.zupacademy.joao.casadocodigo.model.Autor;
import br.com.zupacademy.joao.casadocodigo.repositoy.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        AutorRequest autorRequest = (AutorRequest) target;

        Optional<Autor> autor = autorRepository.findByEmail(autorRequest.getEmail());

        if(autor.isPresent()) {
            errors.rejectValue("email", null, "Já existe um(a) outro(a) e-mail "+autorRequest.getEmail());
        }
    }
}
