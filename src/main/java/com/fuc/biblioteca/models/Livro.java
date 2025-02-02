package com.fuc.biblioteca.models;

import com.fuc.biblioteca.enums.Tamanho;

import javax.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String titulo;
    private String autor;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Tamanho tamanho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    public Livro(Integer id, String titulo, String autor, String texto, Tamanho tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Livro() {
        super();
    }

}