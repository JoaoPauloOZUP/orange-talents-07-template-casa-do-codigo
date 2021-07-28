package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.AutorRequest;
import br.com.zupacademy.joao.casadocodigo.model.Autor;

import java.time.Instant;

public class AutorResponse {

    private String nome;

    private String email;

    private String descricao;

    @Deprecated
    public AutorResponse() { }

    public AutorResponse(AutorRequest autorRequest) {
        this.nome = autorRequest.getNome();
        this.email = autorRequest.getEmail();
        this.descricao = autorRequest.getDescricao();
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

}
