package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;



    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {
        CategoriaDto catDto = categoriaService.findByIdDto(id);
        return ResponseEntity.ok(catDto);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoriaDto>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }


}
