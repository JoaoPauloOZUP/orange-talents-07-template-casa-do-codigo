package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Autor;

import java.time.Instant;

public class AutorResponse {

    private String nome;

    private String email;

    private String descricao;

    private Instant dataCadastro;

    public AutorResponse() { }

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCadastro = autor.getDataCadastro();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }
}
