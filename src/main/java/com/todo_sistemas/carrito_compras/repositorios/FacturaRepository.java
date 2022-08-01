package com.todo_sistemas.carrito_compras.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo_sistemas.carrito_compras.entidades.Factura;

@Repository
@Transactional
public interface FacturaRepository extends CrudRepository<Factura, Long> {
  
}