package com.fuc.biblioteca.services;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;


    //Service método findById e findByIdDto
    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("Categoria não encontrada."));
    }

    public CategoriaDto findByIdDto(Integer id) {
        Categoria cat = findById(id);
        return modelMapper.map(cat, CategoriaDto.class);
    }


    //Service método findAll
    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll()
                .stream().map(obj -> modelMapper.map(obj, CategoriaDto.class))
                .collect(Collectors.toList());
    }


    //Service método save e saveDto
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public CategoriaDto saveDto(CategoriaDto categoriaDto) {
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria savedCategoria = save(categoria);
        return modelMapper.map(savedCategoria, CategoriaDto.class);
    }


}
