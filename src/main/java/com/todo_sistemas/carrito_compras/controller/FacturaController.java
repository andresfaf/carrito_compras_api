package com.todo_sistemas.carrito_compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo_sistemas.carrito_compras.dto.FacturaDto;
import com.todo_sistemas.carrito_compras.dto.ResponseDto;
import com.todo_sistemas.carrito_compras.servicios.IFacturaService;

@RestController
@RequestMapping("api/factura")
public class FacturaController {

  private ResponseDto responseDto;

  public FacturaController() {
    responseDto = new ResponseDto();
    responseDto.setMensaje("Proceso realizado correctamente");
  }

  @Autowired
  IFacturaService facturaService;

  @GetMapping(path = "listar")
  public ResponseEntity<ResponseDto> buscarFacturas() {
    responseDto.setCodigoRespuesta(HttpStatus.OK.value());
    responseDto.setData(facturaService.listarFacturas());
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @PostMapping(path = "guardar")
  public ResponseEntity<ResponseDto> guardar(@RequestBody FacturaDto facturaDto) {
    responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
    responseDto.setData(facturaService.guardarFactura(facturaDto));
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
