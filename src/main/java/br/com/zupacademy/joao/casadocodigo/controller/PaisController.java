package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.PaisRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.PaisResponse;
import br.com.zupacademy.joao.casadocodigo.model.Pais;
import br.com.zupacademy.joao.casadocodigo.repositoy.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisResponse> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);

        return ResponseEntity.ok(new PaisResponse(pais));
    }
}
