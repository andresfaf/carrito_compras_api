package com.todo_sistemas.carrito_compras.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo_sistemas.carrito_compras.dto.FacturaDto;
import com.todo_sistemas.carrito_compras.dto.mapper.FacturaMapper;
import com.todo_sistemas.carrito_compras.entidades.Factura;
import com.todo_sistemas.carrito_compras.repositorios.FacturaRepository;
import com.todo_sistemas.carrito_compras.servicios.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {

  @Autowired
  FacturaRepository facturaRepository;

  @Autowired
  FacturaMapper facturaMapper;

  @Override
  public List<FacturaDto> listarFacturas() {
    List<FacturaDto> facturaDtos = new ArrayList<>();
    List<Factura> facturas = (List<Factura>) facturaRepository.findAll();
    facturaDtos = facturaMapper.modelToDtos(facturas);
    return facturaDtos;
  }

  @Override
  public FacturaDto guardarFactura(FacturaDto facturaDto) {
    if (facturaDto.getIdFactura() == 0) {
      Factura factura = new Factura();
      factura = facturaMapper.dtoToModel(facturaDto);
      factura = facturaRepository.save(factura);
      facturaDto = facturaMapper.modelToDto(factura);
    } else {
      Factura factura = facturaRepository.findById(facturaDto.getIdFactura()).get();
      factura = facturaMapper.dtoToModel(facturaDto);
      factura = facturaRepository.save(factura);
      facturaDto = facturaMapper.modelToDto(factura);
    }
    return facturaDto;
  }
}
