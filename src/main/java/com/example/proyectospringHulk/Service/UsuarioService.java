package com.example.proyectospringHulk.Service;
import com.example.proyectospringHulk.Model.Producto;
import com.example.proyectospringHulk.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    ProductoRepository productoRepo;

    public Producto crearProducto(Producto producto){

        return productoRepo.save(producto);
    }

    public void borrarProducto(int id){

        productoRepo.deleteById(id);
    }

    public List<Producto> listarProductos(){

        return productoRepo.findAll();
    }

    public Producto buscarProductoId(int id){

        return productoRepo.findById(id).orElse(null);
    }

    public void modificarProducto(Producto producto) {

        Optional<Producto> productoEncontrado =
                productoRepo.findById(producto.getId());

        if(productoEncontrado.isPresent()) {
            Producto productoActualizado = productoEncontrado.get();
            productoActualizado.setNombre(producto.getNombre());
            productoActualizado.setPrecio(producto.getPrecio());
            productoActualizado.setDescripcion(producto.getDescripcion());

            productoRepo.save(productoActualizado);
        } else {

            throw new NoSuchElementException("No se encontró el producto con ID " + producto.getId());
        }
    }
}
