package com.example.proyectospringHulk.dto;

public class ProductoDTO {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidad;

    public ProductoDTO() {
    }

    public ProductoDTO(int idProducto, String nombre, String descripcion, float precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters and Setters
}
