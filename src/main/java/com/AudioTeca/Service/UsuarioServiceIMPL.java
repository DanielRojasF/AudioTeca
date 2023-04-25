/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AudioTeca.Service;

import com.AudioTeca.dao.RolDao;
import com.AudioTeca.dao.UsuarioDao;
import com.AudioTeca.domain.Rol;
import com.AudioTeca.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
@Slf4j
public class UsuarioServiceIMPL implements UsuarioService, UserDetailsService {

    @Autowired  
    UsuarioDao usuarioDao;
    
    @Autowired 
    RolDao rolDao;
 
 
    @Override
    @Transactional(readOnly = true) 
    public List<Usuario> getUsuarios() {  
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) 
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }


    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuario = usuarioDao.save(usuario);
        Rol rol = new Rol("ROL_USER", usuario.getIdUsuario());
        rolDao.save(rol);
        
  

    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.deleteById(usuario.getIdUsuario());
    }

    @Override
    public Usuario getUsuarioPorNombre(String nombre) {
        return usuarioDao.findByNombre(nombre);

    }

    @Override
    public List<Usuario> getUsuarioPorTelefono(String telefono) {
        return usuarioDao.findByTelefono(telefono);

    }
    
     @Override 
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        //Busca el usuario por el username en la tabla    
        Usuario usuario = usuarioDao.findByNombre(nombre);
        //Si no existe el usuario lanza una excepción     
        if (usuario == null) {
            throw new UsernameNotFoundException(nombre);
        }
        //Si está acá es porque existe el usuario... sacamos los roles que tiene      
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol
                : usuario.getRoles()) {   //Se sacan los roles          
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se devuelve User (clase de userDetails)     
        return new User(usuario.getNombre(), usuario.getContrasenna(), roles);
    }

  

}
