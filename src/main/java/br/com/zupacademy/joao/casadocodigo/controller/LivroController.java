package br.com.zupacademy.joao.casadocodigo.controller;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.LivroRequest;
import br.com.zupacademy.joao.casadocodigo.controller.dto.response.LivroResponse;
import br.com.zupacademy.joao.casadocodigo.model.Autor;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;
import br.com.zupacademy.joao.casadocodigo.model.Livro;
import br.com.zupacademy.joao.casadocodigo.repositoy.AutorRepository;
import br.com.zupacademy.joao.casadocodigo.repositoy.CategoriaRepository;
import br.com.zupacademy.joao.casadocodigo.repositoy.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
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

        return ResponseEntity.ok().body(new LivroResponse(livro));
    }

    @GetMapping
    public List<LivroResponse> listarLivros() {
        return LivroResponse.convertModel(livroRepository.findAll());
    }
}
