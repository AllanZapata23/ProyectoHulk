package com.example.proyectospringHulk.Repository;

import com.example.proyectospringHulk.Model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    // Additional custom queries can be defined here if needed
}