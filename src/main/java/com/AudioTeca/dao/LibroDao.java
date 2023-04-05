
package com.AudioTeca.dao;

import com.AudioTeca.domain.Libro;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
 
public interface LibroDao extends CrudRepository<Libro, Long> {
    public List<Libro> findByTitulo(String titulo);
}
