package com.example.proyectospringHulk.Service;
import com.example.proyectospringHulk.Model.Usuario;
import com.example.proyectospringHulk.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepo;

    public Usuario crearUsuario(Usuario usuario){

        return usuarioRepo.save(usuario);
    }

    public void borrarUsuario(int id){

       usuarioRepo.deleteById(id);
    }

    public List<Usuario> listarUsuarios(){

        return usuarioRepo.findAll();
    }

    public Usuario buscarUsuarioId(int id){

        return usuarioRepo.findById(id).orElse(null);
    }

    public void modificarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioEncontrado =
                usuarioRepo.findById(usuario.getId());

        if(usuarioEncontrado.isPresent()) {
            Usuario usuarioActualizado = usuarioEncontrado.get();
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setPassword(usuario.getPassword());
            usuarioActualizado.setCorreo(usuario.getCorreo());

            usuarioRepo.save(usuarioActualizado);
        } else {

            throw new NoSuchElementException("No se encontró el producto con ID " + usuario.getId());
        }
    }
}
