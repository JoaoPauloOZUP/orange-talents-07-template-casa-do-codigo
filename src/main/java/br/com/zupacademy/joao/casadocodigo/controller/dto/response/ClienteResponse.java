package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Cliente;

import javax.validation.constraints.NotNull;

public class ClienteResponse {

    private Long id;

    @Deprecated
    public ClienteResponse () { }

    public ClienteResponse (@NotNull Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
