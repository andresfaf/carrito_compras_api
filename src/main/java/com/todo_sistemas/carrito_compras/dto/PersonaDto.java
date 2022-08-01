package com.todo_sistemas.carrito_compras.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
  private Long idPersona;
  private String nombre;
  private String apellido;
  private String documento;
  private String correo;
  private String telefono;
  private boolean estado;
}
