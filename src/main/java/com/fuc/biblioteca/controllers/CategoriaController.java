package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.dtos.CategoriaDto;
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

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id, @RequestBody CategoriaDto categoriaDto) {
        CategoriaDto updateCategoriaDto = categoriaService.update(id, categoriaDto);
        return ResponseEntity.ok().body(updateCategoriaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
