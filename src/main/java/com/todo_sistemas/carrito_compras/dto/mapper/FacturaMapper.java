package com.todo_sistemas.carrito_compras.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.todo_sistemas.carrito_compras.dto.FacturaDto;
import com.todo_sistemas.carrito_compras.entidades.Factura;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
  FacturaMapper MAPPER = Mappers.getMapper(FacturaMapper.class);

  FacturaDto modelToDto(Factura factura);

  @InheritInverseConfiguration
  Factura dtoToModel(FacturaDto facturaDto);

  List<FacturaDto> modelToDtos(List<Factura> facturas);
}
