package com.todo_sistemas.carrito_compras.servicios;

import java.util.List;

import com.todo_sistemas.carrito_compras.dto.CategoriaDto;

public interface ICategoriaService {
  List<CategoriaDto> listarCategorias();
  CategoriaDto buscarCategoria(Long idCategoria);
  CategoriaDto guardarCategoria(CategoriaDto categoriaDto);
  void eliminarCategoria(Long idCategoria);
}
