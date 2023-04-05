package com.AudioTeca.Service;

import com.AudioTeca.domain.Libro;
import java.util.List;


public interface LibroService {
    
    public List<Libro> getLibros(); 
    
    public Libro getLibro(Libro libro);
    
    public void save(Libro libro); // Para insertar o modificar (si viene el idLibro o no)
    
    public void delete(Libro libro);
    
    public List<Libro> getLibroPorTitulo(String titulo);
    
}
