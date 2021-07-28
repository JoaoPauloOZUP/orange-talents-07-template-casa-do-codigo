package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.CategoriaRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.CategoriaResponse;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;
import br.com.zupacademy.joao.casadocodigo.repositoy.CategoriaRepository;
import br.com.zupacademy.joao.casadocodigo.validator.categoria.CategoriaDuplicada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaDuplicada categoriaDuplicada;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaDuplicada);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponse> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().body(new CategoriaResponse(categoriaRequest));
    }

}
