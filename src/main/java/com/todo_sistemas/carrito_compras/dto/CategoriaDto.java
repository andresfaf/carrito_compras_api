package com.todo_sistemas.carrito_compras.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDto {
  private Long idCategoria;
  private String nombre;
  private boolean estado;
}
