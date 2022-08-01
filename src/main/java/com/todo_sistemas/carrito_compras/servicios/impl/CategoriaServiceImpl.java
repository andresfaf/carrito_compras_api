package com.todo_sistemas.carrito_compras.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_sistemas.carrito_compras.dto.CategoriaDto;
import com.todo_sistemas.carrito_compras.dto.mapper.CategoriaMapper;
import com.todo_sistemas.carrito_compras.entidades.Categoria;
import com.todo_sistemas.carrito_compras.excepciones.NoDataFoundException;
import com.todo_sistemas.carrito_compras.repositorios.CategoriaRepository;
import com.todo_sistemas.carrito_compras.servicios.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

  @Autowired
  CategoriaRepository categoriaRepository;

  @Autowired
  CategoriaMapper categoriaMapper;

  @Override
  public List<CategoriaDto> listarCategorias() {
    List<CategoriaDto> categoriaDtos = new ArrayList<>();
    List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
    categoriaDtos = categoriaMapper.modelToDtos(categorias);
    return categoriaDtos;
  }

  @Override
  public CategoriaDto buscarCategoria(Long idCategoria) {
    CategoriaDto categoriaDto = new CategoriaDto();
    if (categoriaRepository.findById(idCategoria).isPresent()) {
      categoriaDto = categoriaMapper.modelToDto(categoriaRepository.findById(idCategoria).get());
    } else {
      throw new NoDataFoundException();
    }
    return categoriaDto;
  }

  @Override
  public CategoriaDto guardarCategoria(CategoriaDto categoriaDto) {
    if (categoriaDto.getIdCategoria() == 0) {
      Categoria categoria = new Categoria();
      categoria = categoriaMapper.dtoToModel(categoriaDto);
      categoria = categoriaRepository.save(categoria);
      categoriaDto = categoriaMapper.modelToDto(categoria);
    } else {
      Categoria categoria = categoriaRepository.findById(categoriaDto.getIdCategoria()).get();
      categoria = categoriaMapper.dtoToModel(categoriaDto);
      categoria = categoriaRepository.save(categoria);
      categoriaDto = categoriaMapper.modelToDto(categoria);
    }
    return categoriaDto;
  }

  @Override
  public void eliminarCategoria(Long idCategoria) {
    categoriaRepository.deleteById(idCategoria);
  }
}
