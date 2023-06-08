package com.example.proyectospringHulk.Model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;

    private String nombre;

    private String password;

    private String correo;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String password, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
    }

    // Getters and Setters
}