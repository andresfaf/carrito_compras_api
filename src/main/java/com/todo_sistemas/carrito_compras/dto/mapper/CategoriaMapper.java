package com.todo_sistemas.carrito_compras.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.todo_sistemas.carrito_compras.dto.CategoriaDto;
import com.todo_sistemas.carrito_compras.entidades.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
  CategoriaMapper MAPPER = Mappers.getMapper(CategoriaMapper.class);

  CategoriaDto modelToDto(Categoria categoria);

  @InheritInverseConfiguration
  Categoria dtoToModel(CategoriaDto categoriaDto);

  List<CategoriaDto> modelToDtos(List<Categoria> categorias);
}
