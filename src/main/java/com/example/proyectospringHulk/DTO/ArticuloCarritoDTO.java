package com.example.proyectospringHulk.dto;

public class ArticuloCarritoDTO {
    private int idArticuloCarrito;
    private int cantidad;
    private CarritoDTO carrito;
    private ProductoDTO producto;

    public ArticuloCarritoDTO() {
    }

    public ArticuloCarritoDTO(int idArticuloCarrito, int cantidad, CarritoDTO carrito, ProductoDTO producto) {
        this.idArticuloCarrito = idArticuloCarrito;
        this.cantidad = cantidad;
        this.carrito = carrito;
        this.producto = producto;
    }

    // Getters and Setters
}