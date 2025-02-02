package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.dtos.LivroDto;
import com.fuc.biblioteca.models.Livro;
import com.fuc.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
