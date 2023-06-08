package com.example.proyectospringHulk.Model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private int idProducto;

    private String nombre;

    private String descripcion;

    private float precio;

    private int cantidad;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String descripcion, float precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return idProducto;
    }

    // Getters and Setters
}