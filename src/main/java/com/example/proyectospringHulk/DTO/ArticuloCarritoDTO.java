package com.example.proyectospringHulk.DTO;

public class ArticuloCarritoDTO {
    private int idArticuloCarrito;
    private int cantidad;
    private com.example.proyectospringHulk.dto.CarritoDTO carrito;
    private com.example.proyectospringHulk.dto.ProductoDTO producto;

    public ArticuloCarritoDTO() {
    }

    public ArticuloCarritoDTO(int idArticuloCarrito, int cantidad, com.example.proyectospringHulk.dto.CarritoDTO carrito, com.example.proyectospringHulk.dto.ProductoDTO producto) {
        this.idArticuloCarrito = idArticuloCarrito;
        this.cantidad = cantidad;
        this.carrito = carrito;
        this.producto = producto;
    }

}