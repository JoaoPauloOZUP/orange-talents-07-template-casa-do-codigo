package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

public class AutorResponse {

    private String mensagem;

    public AutorResponse() {
        this.mensagem = "Um novo autor criado no sistema";
    }

    public String getMensagem() {
        return mensagem;
    }
}
