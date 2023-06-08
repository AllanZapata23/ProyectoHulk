package com.example.proyectospringHulk.Controller;

import com.example.proyectospringHulk.Model.ArticuloCarrito;
import com.example.proyectospringHulk.Repository.ArticuloCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/articulocarritos")
public class ArticuloCarritoController {

    private final ArticuloCarritoRepository articuloCarritoRepository;

    @Autowired
    public ArticuloCarritoController(ArticuloCarritoRepository articuloCarritoRepository) {
        this.articuloCarritoRepository = articuloCarritoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloCarrito> getArticuloCarritoById(@PathVariable int id) {
        Optional<ArticuloCarrito> optionalArticuloCarrito = articuloCarritoRepository.findById(id);
        if (optionalArticuloCarrito.isPresent()) {
            ArticuloCarrito articuloCarrito = optionalArticuloCarrito.get();
            return ResponseEntity.ok(articuloCarrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ArticuloCarrito> createArticuloCarrito(@RequestBody ArticuloCarrito articuloCarrito) {
        ArticuloCarrito createdArticuloCarrito = articuloCarritoRepository.save(articuloCarrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticuloCarrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloCarrito> updateArticuloCarrito(@PathVariable int id, @RequestBody ArticuloCarrito articuloCarrito) {
        Optional<ArticuloCarrito> optionalArticuloCarrito = articuloCarritoRepository.findById(id);
        if (optionalArticuloCarrito.isPresent()) {
            ArticuloCarrito existingArticuloCarrito = optionalArticuloCarrito.get();
            existingArticuloCarrito.setCantidad(articuloCarrito.getCantidad());
            // Update other fields as needed
            ArticuloCarrito updatedArticuloCarrito = articuloCarritoRepository.save(existingArticuloCarrito);
            return ResponseEntity.ok(updatedArticuloCarrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticuloCarrito(@PathVariable int id) {
        Optional<ArticuloCarrito> optionalArticuloCarrito = articuloCarritoRepository.findById(id);
        if (optionalArticuloCarrito.isPresent()) {
            ArticuloCarrito existingArticuloCarrito = optionalArticuloCarrito.get();
            articuloCarritoRepository.delete(existingArticuloCarrito);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
