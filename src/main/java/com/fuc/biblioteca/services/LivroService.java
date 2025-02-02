package com.fuc.biblioteca.services;

import com.fuc.biblioteca.dtos.LivroDto;
import com.fuc.biblioteca.models.Livro;
import com.fuc.biblioteca.repositories.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LivroService {


    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Livro findById(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do livro não encontrado."));
    }

    public LivroDto findByIdDto(Integer id) {
        Livro livro = findById(id);
        return modelMapper.map(livro, LivroDto.class);
    }


}
