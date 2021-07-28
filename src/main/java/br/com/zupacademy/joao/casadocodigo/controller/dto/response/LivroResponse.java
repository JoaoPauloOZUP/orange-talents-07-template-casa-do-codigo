package br.com.zupacademy.joao.casadocodigo.controller.dto.response;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.LivroRequest;
import br.com.zupacademy.joao.casadocodigo.model.Autor;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;

import java.util.Date;

public class LivroResponse {

    private String titulo;

    private String resumo;

    private String sumario;

    private Double preco;

    private Long quantidadePagina;

    private String lsbn;

    private Date dataPublicacao;


    public LivroResponse(LivroRequest livroRequest) {
        this.titulo = livroRequest.getTitulo();
        this.resumo = livroRequest.getResumo();
        this.sumario = livroRequest.getSumario();
        this.preco = livroRequest.getPreco();
        this.quantidadePagina = livroRequest.getQuantidadePagina();
        this.lsbn = livroRequest.getLsbn();
        this.dataPublicacao = livroRequest.getDataPublicacao();
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
}
