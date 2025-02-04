package com.fuc.biblioteca.services;

import com.fuc.biblioteca.dtos.LivroDto;
import com.fuc.biblioteca.exceptions.BadRequestException;
import com.fuc.biblioteca.exceptions.ConflictException;
import com.fuc.biblioteca.exceptions.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Id do livro não encontrado."));
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
        if (livroRepository.existsByTitulo(livro.getTitulo())) {
            throw new ConflictException("Ja existe um livro com este titulo.");
        }

        return livroRepository.save(livro);
    }

    public LivroDto saveDto(LivroDto livroDto) {
        if (livroDto.getTitulo() == null || livroDto.getTitulo().isEmpty()) {
            throw new BadRequestException("O titulo do livro é obrigatório.");
        }

        Livro livro = modelMapper.map(livroDto, Livro.class);
        Livro savedLivro = save(livro);
        return modelMapper.map(savedLivro, LivroDto.class);
    }


    //Service método update dos livros
    public LivroDto update(Integer id, LivroDto livroDto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));

        livro.setTitulo(livroDto.getTitulo());
        livro.setAutor(livroDto.getAutor());
        livro.setTexto(livroDto.getTexto());

        livro = livroRepository.save(livro);

        return modelMapper.map(livro, LivroDto.class);
    }


    //Service métodos delete dos livros
    public void delete(Integer id) {
        if (!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id do Livro não encontrado");
        }

        livroRepository.deleteById(id);
    }


}
