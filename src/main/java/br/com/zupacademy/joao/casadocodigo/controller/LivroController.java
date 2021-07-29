package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.LivroRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.LivroDetalhadoReponse;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.LivroResponse;
import br.com.zupacademy.joao.casadocodigo.model.Livro;
import br.com.zupacademy.joao.casadocodigo.repositoy.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(manager);
        livroRepository.save(livro);

        return ResponseEntity.ok(new LivroResponse(livro));
    }

    @GetMapping
    public List<LivroResponse> listarLivros() {
        List<LivroResponse> list = new ArrayList<>();

        livroRepository.findAll().forEach(livro -> {
            list.add(new LivroResponse(livro));
        });

        return list;
    }

    @GetMapping("{id}")
    public ResponseEntity<LivroDetalhadoReponse> livroDetalhado(@PathVariable Long id) {
        Optional<Livro> livroOPT = livroRepository.findById(id);

        if(livroOPT.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(new LivroDetalhadoReponse(livroOPT.get()));
    }
}
