package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.CategoriaRequest;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;

public class CategoriaResponse {

    private String nome;

    @Deprecated
    public CategoriaResponse () { }

    public CategoriaResponse(CategoriaRequest categoriaRequest) {
        this.nome = categoriaRequest.getNome();
    }

    public String getNome() {
        return nome;
    }
}
