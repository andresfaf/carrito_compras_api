package com.todo_sistemas.carrito_compras.entidades;

import java.sql.Date;

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
@Table(name = "factura")
public class Factura {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_factura")
  private Long idFactura;
  @Column(name = "precio")
  private float precio;
  @Column(name = "fecha_creacion")
  private Date fechaCreacion;
  @Column(name = "id_persona")
  private Long idPersona;
  @Column(name = "id_municipio")
  private Long idMunicipio;
  @Column(name = "direccion")
  private String direccion;
  @Column(name = "barrio")
  private String barrio;
  @Column(name = "quien_recibe")
  private String quienRecibe;
  @Column(name = "estado")
  private boolean estado;
}

