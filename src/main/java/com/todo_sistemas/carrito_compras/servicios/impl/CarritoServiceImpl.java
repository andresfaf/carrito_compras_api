package com.todo_sistemas.carrito_compras.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_sistemas.carrito_compras.dto.CarritoDto;
import com.todo_sistemas.carrito_compras.dto.mapper.CarritoMapper;
import com.todo_sistemas.carrito_compras.entidades.Carrito;
import com.todo_sistemas.carrito_compras.repositorios.CarritoRepository;
import com.todo_sistemas.carrito_compras.servicios.ICarritoService;

@Service
public class CarritoServiceImpl implements ICarritoService {

  @Autowired
  CarritoRepository carritoRepository;

  @Autowired
  CarritoMapper carritoMapper;

  @Override
  public List<CarritoDto> listarCarritos() {
    List<CarritoDto> carritoDtos = new ArrayList<>();
    List<Carrito> facturas = (List<Carrito>) carritoRepository.findAll();
    carritoDtos = carritoMapper.modelToDtos(facturas);
    return carritoDtos;
  }

  @Override
  public CarritoDto guardarCarrito(CarritoDto carritoDto) {
    if (carritoDto.getIdCarrito() == 0) {
      Carrito carrito = new Carrito();
      carrito = carritoMapper.dtoToModel(carritoDto);
      carrito = carritoRepository.save(carrito);
      carritoDto = carritoMapper.modelToDto(carrito);
    } else {
      Carrito carrito = carritoRepository.findById(carritoDto.getIdCarrito()).get();
      carrito = carritoMapper.dtoToModel(carritoDto);
      carrito = carritoRepository.save(carrito);
      carritoDto = carritoMapper.modelToDto(carrito);
    }
    return carritoDto;
  }

}
