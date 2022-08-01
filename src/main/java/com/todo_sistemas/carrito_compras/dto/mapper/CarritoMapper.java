package com.todo_sistemas.carrito_compras.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.todo_sistemas.carrito_compras.dto.CarritoDto;
import com.todo_sistemas.carrito_compras.entidades.Carrito;

@Mapper(componentModel = "spring")
public interface CarritoMapper {
  CarritoMapper MAPPER = Mappers.getMapper(CarritoMapper.class);

  CarritoDto modelToDto(Carrito carrito);

  @InheritInverseConfiguration
  Carrito dtoToModel(CarritoDto carritoDto);

  List<CarritoDto> modelToDtos(List<Carrito> carritos);
}
