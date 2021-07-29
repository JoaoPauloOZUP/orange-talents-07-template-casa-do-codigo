package br.com.zupacademy.joao.casadocodigo.controller.dto.request;

import br.com.zupacademy.joao.casadocodigo.model.Autor;
import br.com.zupacademy.joao.casadocodigo.model.Categoria;
import br.com.zupacademy.joao.casadocodigo.model.Livro;
import br.com.zupacademy.joao.casadocodigo.repositoy.LivroRepository;
import br.com.zupacademy.joao.casadocodigo.validator.campoexistente.ExistValue;
import br.com.zupacademy.joao.casadocodigo.validator.campounico.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.util.Date;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @Min(20)
    @NotNull
    private Double preco;

    @Min(100)
    @NotNull
    private Long quantidadePagina;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "lsbn")
    private String lsbn;

    @NotNull
    @Future
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataPublicacao;

    @NotNull
    @Positive
    @ExistValue(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @NotNull
    @Positive
    @ExistValue(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getQuantidadePagina() {
        return quantidadePagina;
    }

    public void setQuantidadePagina(Long quantidadePagina) {
        this.quantidadePagina = quantidadePagina;
    }

    public String getLsbn() {
        return lsbn;
    }

    public void setLsbn(String lsbn) {
        this.lsbn = lsbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Livro toModel(EntityManager manager) {
        Categoria categoria = manager.find(Categoria.class, this.categoriaId);
        Autor autor = manager.find(Autor.class, this.autorId);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.quantidadePagina, this.lsbn, this.dataPublicacao, categoria, autor);
    }
}
