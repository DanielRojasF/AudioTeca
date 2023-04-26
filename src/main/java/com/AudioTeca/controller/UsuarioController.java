
package com.AudioTeca.controller;

import com.AudioTeca.Service.UsuarioService;
import com.AudioTeca.domain.Rol;
import com.AudioTeca.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsuarioController {
    
  @Autowired
    UsuarioService usuarioService;
    
    
    
    @GetMapping("/usuario/listado")  
    public String inicio(Model model) {
        var usuarios=usuarioService.getUsuarios();
//        
//        var limiteTotal=0;
//        for (var c: usuarios) {
//            limiteTotal+=c.getCredito().getLimite();
//        }
//        model.addAttribute("limiteTotal",limiteTotal);
//        model.addAttribute("totalUsuarios",usuarios.size());
//        
        model.addAttribute("usuarios",usuarios);
        return "/usuario/listado";
    }
    
    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario){
        return "/usuario/modificarUsuario";
    }
    
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }
    
    @GetMapping("usuario/modificar/{idUsuario}")
    public String modificarUsuario(Usuario usuario, Model model){
    usuario = usuarioService.getUsuario(usuario);
    
    
            model.addAttribute("usuario", usuario);
            return "/usuario/modificarUsuario";

    }
    @GetMapping("/usuario/eliminar/{idUsuario}")
    public String eliminarUsuario(Usuario usuario){
     usuarioService.delete(usuario);
            return "redirect:/usuario/listado";
    }
    
  
  @GetMapping("/usuario/buscar")
    public String buscar(Usuario usuario){
        return "/usuario/buscarUsuario";
    }
    
 @PostMapping ("/usuario/busqueda") 
 public String busqueda(Usuario usuario, Model model){
     var usuarios = usuarioService.getUsuarioPorNombre(usuario.getNombre());
     model.addAttribute("resultados",usuarios);
     return "/usuario/buscarUsuario";
     
 }  
 
// @GetMapping("/usuario/inicioPerfil")  
//    public String inicioPerfil(Model model) {
//        var usuarios=usuarioService.getUsuarios();        
//        model.addAttribute("usuarios",usuarios);
//        return "/usuario/modificarPerfil";
//    }
    
//    @GetMapping("/modificarPerfil/{idUsuario}") 
//    public String modificarPerfil(Usuario usuario, Model model){
//        usuario = usuarioService.getUsuario(usuario);
//        model.addAttribute("usuario", usuario);
//        return "/usuario/modificarPerfil";
//    }
//    
//    @GetMapping("/nuevoPerfil")
//    public String nuevoPerfil(Usuario usuario){
//        return "/usuario/modificarPerfil";
//    }
 
 @GetMapping("/usuario/modificarPerfil")
    public String inicioPerfil(Model model){
      var usuario = usuarioService.getClass();
      model.addAttribute("usuario", usuario);
      return "/usuario/modificarPerfil";
    }
    
    @GetMapping("usuario/modificaPerfil/{idUsuario}")
        public String modificarPerfil(Usuario usuario, Model model){
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modificaPerfil";

    }
} 



