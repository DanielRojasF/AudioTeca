package com.AudioTeca.controller;

import com.AudioTeca.Service.LibroService;
import com.AudioTeca.domain.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private LibroService libroService;
    /*Es importante anotar que en 
    Spring se utiliza la interface 
    ClienteService, Spring busca cual 
    clase implementa la interface y 
    la utiliza de manera automática, 
    así se separa aún más la 
    implementación de la interface 
    de la capa de presentación 
    (Controller)
    */

    @GetMapping("/")
    public String inicio(Model model) {
        var libros = libroService.getLibros();
        model.addAttribute("libros", libros);
        return "index";
    }
      
    }
   