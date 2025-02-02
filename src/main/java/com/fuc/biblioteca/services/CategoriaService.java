package com.fuc.biblioteca.services;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;




    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("Categoria não encontrada."));
    }

    public CategoriaDto findByIdDto(Integer id) {
        Categoria cat = findById(id);
        return modelMapper.map(cat, CategoriaDto.class);
    }



    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll()
                .stream().map(obj -> modelMapper.map(obj, CategoriaDto.class))
                .collect(Collectors.toList());
    }

}
