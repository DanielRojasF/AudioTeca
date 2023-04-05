
package com.AudioTeca.dao;

import com.AudioTeca.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    
   public List<Usuario> findByNombre(String nombre);
    
   public List<Usuario> findByTelefono(String telefono);
    
}
    

