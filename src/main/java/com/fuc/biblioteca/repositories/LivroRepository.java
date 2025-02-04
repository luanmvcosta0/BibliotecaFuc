package com.fuc.biblioteca.repositories;

import com.fuc.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

    boolean existsByTitulo(String titulo);

}