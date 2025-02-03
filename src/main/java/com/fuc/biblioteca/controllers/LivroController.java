package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.dtos.LivroDto;
import com.fuc.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @Autowired
    private LivroService livroService;


    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        LivroDto livroDto = livroService.findByIdDto(id);
        return ResponseEntity.ok().body(livroDto);
    }

    @GetMapping("")
    public ResponseEntity<List<LivroDto>> findAll() {
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<LivroDto> save(@RequestBody LivroDto livroDto) {
        LivroDto savedLivroDto = livroService.saveDto(livroDto);
        return ResponseEntity.ok().body(savedLivroDto);
    }

}
