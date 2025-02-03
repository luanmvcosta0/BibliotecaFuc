package com.fuc.biblioteca.services;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.dtos.LivroDto;
import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.models.Livro;
import com.fuc.biblioteca.repositories.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {


    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ModelMapper modelMapper;


    //Service método findById e findByIdDto dos livros
    public Livro findById(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do livro não encontrado."));
    }

    public LivroDto findByIdDto(Integer id) {
        Livro livro = findById(id);
        return modelMapper.map(livro, LivroDto.class);
    }


    //Service método findAll dos livros
    public List<LivroDto> findAll() {
        return livroRepository.findAll()                                                         //Obtenho todos os livros do Banco
                .stream()                                                                        //Converto a lista em uma Stream(fluxo de dados)
                .map(obj -> modelMapper.map(obj, LivroDto.class))    //Transformo cada Livro em LivroDto
                .collect(Collectors.toList());                                           //Converto de volta para uma lista
    }


    //Service método save dos livros
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public LivroDto saveDto(LivroDto livroDto) {
        Livro livro = modelMapper.map(livroDto, Livro.class);
        Livro savedLivro = save(livro);
        return modelMapper.map(savedLivro, LivroDto.class);
    }


}
