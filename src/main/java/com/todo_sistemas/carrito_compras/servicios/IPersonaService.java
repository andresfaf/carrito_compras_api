package com.todo_sistemas.carrito_compras.servicios;

import java.util.List;

import com.todo_sistemas.carrito_compras.dto.PersonaDto;

public interface IPersonaService {
  List<PersonaDto> listarPersonas();
  PersonaDto buscarPersona(Long idPersona);
  PersonaDto guardarPersona(PersonaDto personaDto);
  void eliminarPersona(Long idPersona);
}
