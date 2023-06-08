package com.example.proyectospringHulk.Model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrito")
    private int idCarrito;

    private String estado;

    @OneToOne
    @JoinColumn(name = "usuario_idUsuario")
    private Usuario usuario;

    public Carrito() {
    }

    public Carrito(int idCarrito, String estado, Usuario usuario) {
        this.idCarrito = idCarrito;
        this.estado = estado;
        this.usuario = usuario;
    }
    public Integer getId() {
        return idCarrito;
    }

    // Getters and Setters
}