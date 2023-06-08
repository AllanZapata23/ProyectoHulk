package com.example.proyectospringHulk.Repository;

import com.example.proyectospringHulk.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Additional custom queries can be defined here if needed
}