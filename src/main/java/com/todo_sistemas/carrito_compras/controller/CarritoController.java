package com.todo_sistemas.carrito_compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo_sistemas.carrito_compras.dto.CarritoDto;
import com.todo_sistemas.carrito_compras.dto.ResponseDto;
import com.todo_sistemas.carrito_compras.servicios.ICarritoService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {

  private ResponseDto responseDto;

  public CarritoController() {
    responseDto = new ResponseDto();
    responseDto.setMensaje("Proceso realizado correctamente");
  }

  @Autowired
  ICarritoService carritoService;

  @PostMapping(path = "guardar")
  public ResponseEntity<ResponseDto> guardar(@RequestBody CarritoDto carritoDto) {
    responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
    responseDto.setData(carritoService.guardarCarrito(carritoDto));
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping(path = "listar")
  public ResponseEntity<ResponseDto> buscarCarritos() {
    responseDto.setCodigoRespuesta(HttpStatus.OK.value());
    responseDto.setData(carritoService.listarCarritos());
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
