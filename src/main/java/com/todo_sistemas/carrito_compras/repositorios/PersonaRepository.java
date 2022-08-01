package com.todo_sistemas.carrito_compras.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo_sistemas.carrito_compras.entidades.Persona;

@Repository
@Transactional
public interface PersonaRepository extends CrudRepository<Persona, Long> {
  
}
