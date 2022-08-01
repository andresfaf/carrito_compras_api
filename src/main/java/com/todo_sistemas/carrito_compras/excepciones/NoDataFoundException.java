package com.todo_sistemas.carrito_compras.excepciones;

public class NoDataFoundException extends RuntimeException {
  public NoDataFoundException()
    {
        super("No existen registros");
    }
}
