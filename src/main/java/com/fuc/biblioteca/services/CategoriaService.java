package com.fuc.biblioteca.services;

import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElse(null);
    }

}
