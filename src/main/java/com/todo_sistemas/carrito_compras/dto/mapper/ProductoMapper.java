package com.todo_sistemas.carrito_compras.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.todo_sistemas.carrito_compras.dto.ProductoDto;
import com.todo_sistemas.carrito_compras.entidades.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
  ProductoMapper MAPPER = Mappers.getMapper(ProductoMapper.class);

  ProductoDto modelToDto(Producto producto);

  @InheritInverseConfiguration
  Producto dtoToModel(ProductoDto productoDto);

  List<ProductoDto> modelToDtos(List<Producto> productos);
}
