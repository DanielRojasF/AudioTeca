
package com.AudioTeca.dao;

import com.AudioTeca.domain.Libro;
import com.AudioTeca.domain.Rol;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
 


public interface RolDao extends CrudRepository<Rol, Long> {
    
    
}
