package br.com.zupacademy.joao.casadocodigo.controller.dto.request;

import br.com.zupacademy.joao.casadocodigo.model.Pais;
import br.com.zupacademy.joao.casadocodigo.validator.campoexistente.ExistValue;
import br.com.zupacademy.joao.casadocodigo.validator.paisestado.PaisEstadoExistValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@PaisEstadoExistValue
public class LocalidadeRequest {

    @NotNull
    @Positive
    @ExistValue(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    @NotNull
    @Positive
    private Long estadoId;

    @Deprecated
    public LocalidadeRequest() {}

    public LocalidadeRequest(@NotNull @Positive Long paisId, @Positive Long estadoId) {
        this.paisId = paisId;
        this.estadoId = estadoId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}

