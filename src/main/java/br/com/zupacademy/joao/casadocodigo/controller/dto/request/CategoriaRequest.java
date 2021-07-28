package br.com.zupacademy.joao.casadocodigo.controller.dto.request;

import br.com.zupacademy.joao.casadocodigo.model.Categoria;
import br.com.zupacademy.joao.casadocodigo.validator.campounico.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public CategoriaRequest () { }

    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
