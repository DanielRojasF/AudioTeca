/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.AudioTeca.Service;

import com.AudioTeca.domain.Usuario;
import java.util.List;

/**
 *
 * @author Stiphen Campos
 */
public interface UsuarioService {
    
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    
    public void save(Usuario usuario); // Para insertar o modificar (si viene el idUsuario o no)
    
    public void delete(Usuario usuario);
    
     public List<Usuario> getUsuarioPorNombre(String nombre);
    
    public List<Usuario> getUsuarioPorTelefono(String telefono);
    
 
    
}

    
    

