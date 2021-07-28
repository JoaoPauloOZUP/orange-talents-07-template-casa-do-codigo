package br.com.zupacademy.joao.casadocodigo.validator.categoria;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.CategoriaRequest;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;
import br.com.zupacademy.joao.casadocodigo.repositoy.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicada implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CategoriaRequest categoriaRequest = (CategoriaRequest) target;

        Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaRequest.getNome());

        if(categoria.isPresent()){
            errors.rejectValue("Nome", null, "Categoria já existente "+categoriaRequest.getNome());
        }
    }
}
