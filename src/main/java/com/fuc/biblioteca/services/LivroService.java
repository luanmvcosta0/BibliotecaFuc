package com.fuc.biblioteca.services;

import com.fuc.biblioteca.repositories.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ModelMapper modelMapper;

}
