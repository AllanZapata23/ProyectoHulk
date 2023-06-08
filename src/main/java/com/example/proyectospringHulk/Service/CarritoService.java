package com.example.proyectospringHulk.Service;
import com.example.proyectospringHulk.Model.Carrito;
import com.example.proyectospringHulk.Model.Producto;
import com.example.proyectospringHulk.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarritoService {
    @Autowired
    CarritoRepository carritoRepo;

    public Carrito crearCarrito(Carrito carrito){

        return carritoRepo.save(carrito);
    }

    public void borrarCarrito(int id){

        carritoRepo.deleteById(id);
    }

    public List<Carrito> listarCarritos(){

        return carritoRepo.findAll();
    }

    public Carrito buscarCarritoId(int id){

        return carritoRepo.findById(id).orElse(null);
    }

    public void modificarCarrito(Carrito carrito) {

        Optional<Carrito> carritoEncontrado =
                carritoRepo.findById(carrito.getId());

        if(carritoEncontrado.isPresent()) {
            Carrito carritoActualizado = carritoEncontrado.get();
            carritoActualizado.setEstado(carrito.getEstado());
            carritoActualizado.setUsuario(carrito.getUsuario());
            carritoRepo.save(carritoActualizado);
        } else {

            throw new NoSuchElementException("No se encontró el producto con ID " + carrito.getId());
        }
    }
}
