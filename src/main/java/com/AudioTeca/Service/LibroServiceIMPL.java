/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AudioTeca.Service;

import com.AudioTeca.dao.LibroDao;
import com.AudioTeca.domain.Libro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stiphen Campos
 */
@Service
public class LibroServiceIMPL implements LibroService{
    
    @Autowired
    LibroDao libroDao;
    
    @Override
    @Transactional(readOnly = true)
    public  List<Libro> getLibros() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Libro getLibro(Libro libro) {
        return libroDao.findById(libro.getIdLibro()).orElse( null);
    }
    @Override
    @Transactional
    public void save(Libro libro) {
       
         libroDao.save(libro);
    }

    @Override
    @Transactional
    public void delete(Libro libro) {
        libroDao.deleteById(libro.getIdLibro());
    }
    
    @Override
    public List<Libro> getLibroPorTitulo(String titulo) {
        return libroDao.findByTitulo(titulo);
 
    }
}
