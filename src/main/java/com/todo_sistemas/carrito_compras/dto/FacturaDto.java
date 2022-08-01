package com.todo_sistemas.carrito_compras.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDto {
  private Long idFactura;
  private float precio;
  private Date fechaCreacion;
  private Long idPersona;
  private Long idMunicipio;
  private String direccion;
  private String barrio;
  private String quienRecibe;
  private boolean estado;
}
