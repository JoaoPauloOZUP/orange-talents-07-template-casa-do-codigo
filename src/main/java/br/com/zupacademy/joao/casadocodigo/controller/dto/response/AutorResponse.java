package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Autor;

public class AutorResponse {

    private Long id;

    private String email;

    @Deprecated
    public AutorResponse() { }

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.email = autor.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
