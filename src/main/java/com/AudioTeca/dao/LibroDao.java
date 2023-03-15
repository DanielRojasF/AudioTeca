
package com.AudioTeca.dao;

import com.AudioTeca.domain.Libro;
import org.springframework.data.repository.CrudRepository;


public interface LibroDao extends CrudRepository<Libro, Long> {
    
}
