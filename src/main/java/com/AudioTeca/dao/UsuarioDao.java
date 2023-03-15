
package com.AudioTeca.dao;

import com.AudioTeca.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    
}
