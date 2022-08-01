package com.todo_sistemas.carrito_compras.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
  private Long idProducto;
  private String nombre;
  private Long idCategoria;
  private float precio;
  private Long cantidad;
  private boolean estado;
}
