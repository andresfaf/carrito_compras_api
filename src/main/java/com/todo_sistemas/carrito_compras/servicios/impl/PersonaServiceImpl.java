package com.todo_sistemas.carrito_compras.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_sistemas.carrito_compras.dto.PersonaDto;
import com.todo_sistemas.carrito_compras.dto.mapper.PersonaMapper;
import com.todo_sistemas.carrito_compras.entidades.Persona;
import com.todo_sistemas.carrito_compras.excepciones.NoDataFoundException;
import com.todo_sistemas.carrito_compras.repositorios.PersonaRepository;
import com.todo_sistemas.carrito_compras.servicios.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

  @Autowired
  PersonaRepository personaRepository;

  @Autowired
  PersonaMapper personaMapper;

  @Override
  public List<PersonaDto> listarPersonas() {
    List<PersonaDto> personaDtos = new ArrayList<>();
    List<Persona> personas = (List<Persona>) personaRepository.findAll();
    personaDtos = personaMapper.modelToDtos(personas);
    return personaDtos;
  }

  @Override
  public PersonaDto buscarPersona(Long idPersona) {
    PersonaDto personaDto = new PersonaDto();
    if (personaRepository.findById(idPersona).isPresent()) {
      personaDto = personaMapper.modelToDto(personaRepository.findById(idPersona).get());
    } else {
      throw new NoDataFoundException();
    }
    return personaDto;
  }

  @Override
  public PersonaDto guardarPersona(PersonaDto personaDto) {
    if (personaDto.getIdPersona() == 0) {
      Persona persona = new Persona();
      persona = personaMapper.dtoToModel(personaDto);
      persona = personaRepository.save(persona);
      personaDto = personaMapper.modelToDto(persona);
    } else {
      Persona persona = personaRepository.findById(personaDto.getIdPersona()).get();
      persona = personaMapper.dtoToModel(personaDto);
      persona = personaRepository.save(persona);
      personaDto = personaMapper.modelToDto(persona);
    }
    return personaDto;
  }

  @Override
  public void eliminarPersona(Long idPersona) {
    personaRepository.deleteById(idPersona);
  }
}
