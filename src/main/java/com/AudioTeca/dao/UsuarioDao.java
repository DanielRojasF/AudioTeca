package com.AudioTeca.dao;

import com.AudioTeca.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface UsuarioDao extends CrudRepository<Usuario, Long> {
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByNombre(String nombre); 

//    public List<Usuario> findByNombre(String nombre);

    public List<Usuario> findByTelefono(String telefono);

}
 