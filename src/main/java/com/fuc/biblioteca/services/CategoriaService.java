package com.fuc.biblioteca.services;

import com.fuc.biblioteca.dtos.CategoriaDto;
import com.fuc.biblioteca.exceptions.ResourceNotFoundException;
import com.fuc.biblioteca.models.Categoria;
import com.fuc.biblioteca.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;


    //Service método findById e findByIdDto das categorias
    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id da categoria não encontrado"));
    }

    public CategoriaDto findByIdDto(Integer id) {
        Categoria cat = findById(id);
        return modelMapper.map(cat, CategoriaDto.class);
    }


    //Service método findAll das categorias
    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll()                                                        //Obtenho todos os livros do Banco
                .stream()                                                                           //Converto a lista em uma Stream(fluxo de dados)
                .map(obj -> modelMapper.map(obj, CategoriaDto.class))   //Transformo cada Livro em LivroDto
                .collect(Collectors.toList());                                              //Converto de volta para uma lista
    }


    //Service método save e saveDto de categoria
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public CategoriaDto saveDto(CategoriaDto categoriaDto) {
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria savedCategoria = save(categoria);
        return modelMapper.map(savedCategoria, CategoriaDto.class);
    }


    //Service método para atualizar uma categoria
    public CategoriaDto update(Integer id, CategoriaDto categoriaDto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        //Atualiza os dados da categoria
        categoria.setGenero(categoriaDto.getGenero());
        categoria.setDescricao(categoriaDto.getDescricao());

        //Salva a atualização
        categoria = categoriaRepository.save(categoria);

        //Retorna um DTO atualizado
        return modelMapper.map(categoria, CategoriaDto.class);
    }


    //Service método para deletar uma categoria por id
    public void delete(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id da categoria não encontrado.");
        }

        categoriaRepository.deleteById(id);
    }

}
