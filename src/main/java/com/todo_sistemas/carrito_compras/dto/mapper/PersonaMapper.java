package com.todo_sistemas.carrito_compras.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.todo_sistemas.carrito_compras.dto.PersonaDto;
import com.todo_sistemas.carrito_compras.entidades.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
  PersonaMapper MAPPER = Mappers.getMapper(PersonaMapper.class);

  PersonaDto modelToDto(Persona persona);

  @InheritInverseConfiguration
  Persona dtoToModel(PersonaDto personaDto);

  List<PersonaDto> modelToDtos(List<Persona> personas);
}
