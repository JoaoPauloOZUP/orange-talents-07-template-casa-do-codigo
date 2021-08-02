package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.ClienteRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.ClienteResponse;
import br.com.zupacademy.joao.casadocodigo.model.Cliente;
import br.com.zupacademy.joao.casadocodigo.repositoy.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(manager);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteResponse(cliente));
    }
}
