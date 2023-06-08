package com.example.proyectospringHulk.Controller;

import com.example.proyectospringHulk.Model.Carrito;
import com.example.proyectospringHulk.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    private final CarritoRepository carritoRepository;

    @Autowired
    public CarritoController(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable int id) {
        Optional<Carrito> optionalCarrito = carritoRepository.findById(id);
        if (optionalCarrito.isPresent()) {
            Carrito carrito = optionalCarrito.get();
            return ResponseEntity.ok(carrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Carrito> createCarrito(@RequestBody Carrito carrito) {
        Carrito createdCarrito = carritoRepository.save(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable int id, @RequestBody Carrito carrito) {
        Optional<Carrito> optionalCarrito = carritoRepository.findById(id);
        if (optionalCarrito.isPresent()) {
            Carrito existingCarrito = optionalCarrito.get();
            existingCarrito.setIdCarrito(carrito.getIdCarrito());
            existingCarrito.setEstado(carrito.getEstado());
            existingCarrito.setUsuario(carrito.getUsuario());
            Carrito updatedCarrito = carritoRepository.save(existingCarrito);
            return ResponseEntity.ok(updatedCarrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable int id) {
        Optional<Carrito> optionalCarrito = carritoRepository.findById(id);
        if (optionalCarrito.isPresent()) {
            Carrito existingCarrito = optionalCarrito.get();
            carritoRepository.delete(existingCarrito);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
