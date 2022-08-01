package com.todo_sistemas.carrito_compras.servicios;

import java.util.List;

import com.todo_sistemas.carrito_compras.dto.CarritoDto;

public interface ICarritoService {
  List<CarritoDto> listarCarritos();
  CarritoDto guardarCarrito(CarritoDto carritoDto);
}
