package com.fuc.biblioteca.models;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String genero;
    private String descricao;



    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public Categoria(Integer id, String genero, String descricao) {
        this.id = id;
        this.genero = genero;
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Categoria() {
        super();

    }
}
