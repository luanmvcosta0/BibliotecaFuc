package com.fuc.biblioteca.controllers;

import com.fuc.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @Autowired
    private LivroService livroService;



}
