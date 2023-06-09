package com.example.proyectospringHulk.Service;

import com.example.proyectospringHulk.Model.ArticuloCarrito;
import com.example.proyectospringHulk.Repository.ArticuloCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticuloCarritoService {

    private final ArticuloCarritoRepository articuloCarritoRepo;

    @Autowired
    public ArticuloCarritoService(ArticuloCarritoRepository articuloCarritoRepo) {
        this.articuloCarritoRepo = articuloCarritoRepo;
    }

    public ArticuloCarrito crearArticuloCarrito(ArticuloCarrito articuloCarrito) {
        return articuloCarritoRepo.save(articuloCarrito);
    }

    public void borrarArticuloCarrito(int id) {
        articuloCarritoRepo.deleteById(id);
    }

    public List<ArticuloCarrito> listarArticulosCarrito() {
        return articuloCarritoRepo.findAll();
    }

    public ArticuloCarrito obtenerArticuloCarritoPorId(int id) {
        return articuloCarritoRepo.findById(id).orElse(null);
    }

    public void modificarArticuloCarrito(ArticuloCarrito articuloCarrito) {
        Optional<ArticuloCarrito> articuloCarritoEncontrado = articuloCarritoRepo.findById(articuloCarrito.getId());

        if (articuloCarritoEncontrado.isPresent()) {
            ArticuloCarrito articuloCarritoActualizado = articuloCarritoEncontrado.get();
            articuloCarritoActualizado.setCantidad(articuloCarrito.getCantidad());
            articuloCarritoRepo.save(articuloCarritoActualizado);
        } else {
            throw new NoSuchElementException("No se encontró el artículo con ID " + articuloCarrito.getId());
        }
    }
}
