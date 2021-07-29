package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.LivroRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.LivroDetalhadoReponse;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.LivroResponse;
import br.com.zupacademy.joao.casadocodigo.model.Autor;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;
import br.com.zupacademy.joao.casadocodigo.model.Livro;
import br.com.zupacademy.joao.casadocodigo.repositoy.AutorRepository;
import br.com.zupacademy.joao.casadocodigo.repositoy.CategoriaRepository;
import br.com.zupacademy.joao.casadocodigo.repositoy.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
        Optional<Categoria> categoriaOPT = categoriaRepository.findById(livroRequest.getCategoriaId());
        Optional<Autor> autorOPT = autorRepository.findById(livroRequest.getAutorId());

        Livro livro = livroRequest.toModel(livroRepository, categoriaOPT.get(), autorOPT.get());
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
