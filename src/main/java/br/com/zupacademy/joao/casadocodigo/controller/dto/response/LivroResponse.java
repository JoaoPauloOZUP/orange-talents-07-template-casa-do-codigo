package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroResponse {

    private Long id;

    private String titulo;

    @Deprecated
    public  LivroResponse() { }

    public LivroResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroResponse> convertModel(List<Livro> list) {
        List<LivroResponse> livroResponseList = new ArrayList<>();
        list.forEach(livro -> {
            LivroResponse response = new LivroResponse(livro.getId(), livro.getTitulo());
            livroResponseList.add(response);
        });

        return livroResponseList;
    }
}
