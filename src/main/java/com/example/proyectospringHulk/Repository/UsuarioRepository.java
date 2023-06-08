package com.example.proyectospringHulk.Repository;

import com.example.proyectospringHulk.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Additional custom queries can be defined here if needed
}