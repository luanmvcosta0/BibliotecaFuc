package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

}
