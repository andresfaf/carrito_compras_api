package com.todo_sistemas.carrito_compras.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_sistemas.carrito_compras.dto.ProductoDto;
import com.todo_sistemas.carrito_compras.dto.mapper.ProductoMapper;
import com.todo_sistemas.carrito_compras.entidades.Producto;
import com.todo_sistemas.carrito_compras.excepciones.NoDataFoundException;
import com.todo_sistemas.carrito_compras.repositorios.ProductoRepository;
import com.todo_sistemas.carrito_compras.servicios.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

  @Autowired
  ProductoRepository productoRepository;

  @Autowired
  ProductoMapper productoMapper;

  @Override
  public List<ProductoDto> listarProductos() {
    List<ProductoDto> productoDtos = new ArrayList<>();
    List<Producto> productos = (List<Producto>) productoRepository.findAll();
    productoDtos = productoMapper.modelToDtos(productos);
    return productoDtos;
  }

  @Override
  public ProductoDto buscarProducto(Long idProducto) {
    ProductoDto productoDto = new ProductoDto();
    if (productoRepository.findById(idProducto).isPresent()) {
      productoDto = productoMapper.modelToDto(productoRepository.findById(idProducto).get());
    } else {
      throw new NoDataFoundException();
    }
    return productoDto;
  }

  @Override
  public ProductoDto guardarProducto(ProductoDto productoDto) {
    if (productoDto.getIdProducto() == 0) {
      Producto producto = new Producto();
      producto = productoMapper.dtoToModel(productoDto);
      producto = productoRepository.save(producto);
      productoDto = productoMapper.modelToDto(producto);
    } else {
      Producto producto = productoRepository.findById(productoDto.getIdProducto()).get();
      producto = productoMapper.dtoToModel(productoDto);
      producto = productoRepository.save(producto);
      productoDto = productoMapper.modelToDto(producto);
    }
    return productoDto;
  }

  @Override
  public void eliminarProducto(Long idProducto) {
    productoRepository.deleteById(idProducto);
  }
}
