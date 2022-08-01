package com.todo_sistemas.carrito_compras.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarritoDto {
  private Long idCarrito;
  private Long idProducto;
  private Long cantidad;
  private Long idFactura;
  private boolean estado;
}
