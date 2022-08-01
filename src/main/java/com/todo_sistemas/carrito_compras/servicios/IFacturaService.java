package com.todo_sistemas.carrito_compras.servicios;

import java.util.List;

import com.todo_sistemas.carrito_compras.dto.FacturaDto;

public interface IFacturaService {
  List<FacturaDto> listarFacturas();
  FacturaDto guardarFactura(FacturaDto facturaDto);
}
