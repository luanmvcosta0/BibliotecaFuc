package com.fuc.biblioteca.repositories;

import com.fuc.biblioteca.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    boolean existsByGenero(String Genero);

}