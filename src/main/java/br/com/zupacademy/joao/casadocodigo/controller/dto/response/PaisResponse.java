package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Pais;

public class PaisResponse {

    private Long id;

    private String nome;

    @Deprecated
    public PaisResponse() { }

    public PaisResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PaisResponse(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
