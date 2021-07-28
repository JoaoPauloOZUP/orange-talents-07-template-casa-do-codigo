package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Categoria;

public class CategoriaResponse {

    private Long id;

    private String nome;

    @Deprecated
    public CategoriaResponse () { }

    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
