package com.todo_sistemas.carrito_compras.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Long idProducto;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "id_categoria")
  private Long idCategoria;
  @Column(name = "precio")
  private float precio;
  @Column(name = "cantidad")
  private Long cantidad;
  @Column(name = "estado")
  private boolean estado;
}
