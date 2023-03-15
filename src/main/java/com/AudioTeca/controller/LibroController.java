/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.AudioTeca.controller;

import com.AudioTeca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Stiphen Campos
 */
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
    
}
