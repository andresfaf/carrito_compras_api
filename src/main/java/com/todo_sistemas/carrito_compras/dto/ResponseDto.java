package com.todo_sistemas.carrito_compras.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private int codigoRespuesta; //200,201, 500, 404
    private String mensaje; //Proceso correctamente
    private Object data; // instancia, string, valor listado de algo
}
