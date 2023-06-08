package com.example.proyectospringHulk.dto;

public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String correo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int idUsuario, String nombre, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters and Setters
}