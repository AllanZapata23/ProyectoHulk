package com.example.proyectospringHulk.Repository;

import com.example.proyectospringHulk.Model.ArticuloCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloCarritoRepository extends JpaRepository<ArticuloCarrito, Integer> {
    // Additional custom queries can be defined here if needed
}