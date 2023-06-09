package com.example.proyectospringHulk.Model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ArticuloCarrito")
public class ArticuloCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArticuloCarrito")
    private int idArticuloCarrito;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "carrito_idCarrito")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "producto_idProducto")
    private Producto producto;

    public ArticuloCarrito() {
    }

    public ArticuloCarrito(int idArticuloCarrito, int cantidad, Carrito carrito, Producto producto) {
        this.idArticuloCarrito = idArticuloCarrito;
        this.cantidad = cantidad;
        this.carrito = carrito;
        this.producto = producto;
    }
    public Integer getId() {
        return idArticuloCarrito;
    }


}