package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.AutorRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.AutorResponse;
import br.com.zupacademy.joao.casadocodigo.model.Autor;
import br.com.zupacademy.joao.casadocodigo.repositoy.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);

        return ResponseEntity.ok(new AutorResponse(autor));
    }
}
