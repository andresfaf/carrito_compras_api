package com.todo_sistemas.carrito_compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo_sistemas.carrito_compras.dto.ProductoDto;
import com.todo_sistemas.carrito_compras.dto.ResponseDto;
import com.todo_sistemas.carrito_compras.servicios.IProductoService;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

  private ResponseDto responseDto;

  public ProductoController() {
    responseDto = new ResponseDto();
    responseDto.setMensaje("Proceso realizado correctamente");
  }

  @Autowired
  IProductoService productoService;

  @GetMapping(path = "listar")
  public ResponseEntity<ResponseDto> buscarProductos() {
    responseDto.setCodigoRespuesta(HttpStatus.OK.value());
    responseDto.setData(productoService.listarProductos());
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping(path = "buscarporid/{id}")
  public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id) {
    responseDto.setCodigoRespuesta(HttpStatus.OK.value());
    responseDto.setData(productoService.buscarProducto(id));

    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @PostMapping(path = "guardar")
  public ResponseEntity<ResponseDto> guardar(@RequestBody ProductoDto productoDto) {
    responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
    responseDto.setData(productoService.guardarProducto(productoDto));
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @DeleteMapping(path = "eliminar/{id}")
  public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id) {
    responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
    productoService.eliminarProducto(id);
    responseDto.setData(null);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
