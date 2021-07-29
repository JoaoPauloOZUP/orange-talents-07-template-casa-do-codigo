package br.com.zupacademy.joao.casadocodigo.controller.dto.request;

import br.com.zupacademy.joao.casadocodigo.model.Estado;
import br.com.zupacademy.joao.casadocodigo.model.Pais;
import br.com.zupacademy.joao.casadocodigo.validator.campoexistente.ExistValue;
import br.com.zupacademy.joao.casadocodigo.validator.campounico.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @Positive
    @NotNull
    @ExistValue(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, this.paisId);
        return new Estado(this.nome, pais);
    }
}
