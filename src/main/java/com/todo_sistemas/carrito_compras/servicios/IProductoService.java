package com.todo_sistemas.carrito_compras.servicios;

import java.util.List;

import com.todo_sistemas.carrito_compras.dto.ProductoDto;

public interface IProductoService {
  List<ProductoDto> listarProductos();
  ProductoDto buscarProducto(Long idProducto);
  ProductoDto guardarProducto(ProductoDto productoDto);
  void eliminarProducto(Long idProducto);
}
