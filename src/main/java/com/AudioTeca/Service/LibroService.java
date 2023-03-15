/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.AudioTeca.Service;

import com.AudioTeca.domain.Libro;
import java.util.List;

/**
 *
 * @author Stiphen Campos
 */
public interface LibroService {
    
    public List<Libro> getLibros();
    
    public Libro getLibro(Libro libro);
    
    public void save(Libro libro); // Para insertar o modificar (si viene el idLibro o no)
    
    public void delete(Libro libro);
    
}
