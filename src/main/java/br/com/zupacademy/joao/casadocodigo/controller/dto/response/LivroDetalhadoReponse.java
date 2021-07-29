package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.model.Livro;

import javax.persistence.EntityManager;
import java.util.Date;

public class LivroDetalhadoReponse {

    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private Double preco;

    private Long quantidadePagina;

    private String lsbn;

    private Date dataPublicacao;

    private String categoria;

    private String autor;

    @Deprecated
    public LivroDetalhadoReponse() { }

    public LivroDetalhadoReponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.quantidadePagina = livro.getQuantidadePagina();
        this.lsbn = livro.getLsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria().getNome();
        this.autor = livro.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Long getQuantidadePagina() {
        return quantidadePagina;
    }

    public String getLsbn() {
        return lsbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public LivroDetalhadoReponse convertModel(Livro livro) {
        return new LivroDetalhadoReponse();
    }
}
