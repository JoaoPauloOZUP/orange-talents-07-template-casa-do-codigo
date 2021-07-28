package br.com.zupacademy.joao.casadocodigo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private Double preco;

    private Long quantidadePagina;

    private String lsbn;

    private Date dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() { }

    public Livro(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario, @Min(20) Double preco, @Min(100) Long quantidadePagina, @NotBlank String lsbn, @Future Date dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePagina = quantidadePagina;
        this.lsbn = lsbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
