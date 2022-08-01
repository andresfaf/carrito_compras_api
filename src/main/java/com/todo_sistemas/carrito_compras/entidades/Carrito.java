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
@Table(name = "carrito")
public class Carrito {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_carrito")
  private Long idCarrito;
  @Column(name = "id_producto")
  private Long idProducto;
  @Column(name = "cantidad")
  private Long cantidad;
  @Column(name = "id_factura")
  private Long idFactura;
  @Column(name = "estado")
  private boolean estado;


}
