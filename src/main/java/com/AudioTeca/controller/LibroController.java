/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.AudioTeca.controller;

import com.AudioTeca.Service.LibroService;
import com.AudioTeca.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibroController {
    
    @Autowired
    LibroService libroService;
    
    
    
    @GetMapping("/libro/listado") 
    public String inicio(Model model) {
       
       
                var libros = libroService .getLibros();
                model.addAttribute("libros", libros);
                
        return "/libro/listado";
    }
    
    @GetMapping("/libro/nuevo")
    public String nuevoLibro(Libro libro){
        return "/libro/modificarLibro";
    }
    
    @PostMapping("/libro/guardar")
    public String guardarLibro(Libro libro){
        libroService.save(libro);
        return "redirect:/libro/listado";
    }
    
    @GetMapping("libro/modificar/{idLibro}")
    public String modificarLibro(Libro libro, Model model){
    libro = libroService.getLibro(libro);
    
    
            model.addAttribute("libro", libro);
            return "/libro/modificarLibro";
 
    }
    @GetMapping("/libro/eliminar/{idLibro}")
    public String eliminarLibro(Libro libro){
     libroService.delete(libro);
            return "redirect:/libro/listado";
    }
    
  
  @GetMapping("/libro/buscar")
    public String buscar(Libro libro){
        return "/libro/buscarLibro";
    }
    
@PostMapping ("/libro/busqueda")
public String busqueda(Libro libro, Model model){
     var libros = libroService.getLibroPorTitulo(libro.getTitulo());
     model.addAttribute("resultados",libros);
     return "/libro/buscarLibro";
     
}  
    
}
