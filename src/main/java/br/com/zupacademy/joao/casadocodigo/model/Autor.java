package br.com.zupacademy.joao.casadocodigo.model;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.AutorRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String descricao;

    private Instant dataCadastro = Instant.now();

    public Autor() { }

    public Autor(AutorRequest autorRequest) {
        this.nome = autorRequest.getNome();
        this.email = autorRequest.getEmail();
        this.descricao = autorRequest.getDescricao();
    }

    public Long getId() {
        return id;
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
