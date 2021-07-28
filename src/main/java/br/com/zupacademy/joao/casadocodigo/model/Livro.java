package br.com.zupacademy.joao.casadocodigo.model;

import javax.persistence.*;
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

    public Livro(String titulo, String resumo, String sumario, Double preco, Long quantidadePagina, String lsbn, Date dataPublicacao, Categoria categoria, Autor autor) {
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
