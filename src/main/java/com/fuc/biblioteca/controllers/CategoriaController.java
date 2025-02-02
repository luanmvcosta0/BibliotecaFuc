package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("")
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto) {
        CategoriaDto savedCategoriaDto = categoriaService.saveDto(categoriaDto);
        return ResponseEntity.ok(savedCategoriaDto);
    }


}
