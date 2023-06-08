package com.example.proyectospringHulk.dto;

public class CarritoDTO {
    private int idCarrito;
    private String estado;
    private UsuarioDTO usuario;

    public CarritoDTO() {
    }

    public CarritoDTO(int idCarrito, String estado, UsuarioDTO usuario) {
        this.idCarrito = idCarrito;
        this.estado = estado;
        this.usuario = usuario;
    }

    // Getters and Setters
}