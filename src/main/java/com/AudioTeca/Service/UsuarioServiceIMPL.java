/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.AudioTeca.Service;

import com.AudioTeca.dao.UsuarioDao;
import com.AudioTeca.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stiphen Campos
 */
@Service
public class UsuarioServiceIMPL implements UsuarioService{
    
    @Autowired
    UsuarioDao usuarioDao;
    
   
    

    @Override
    @Transactional(readOnly = true)
    public  List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse( null);
    }
    @Override
    @Transactional
    public void save(Usuario usuario) {
       
         usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.deleteById(usuario.getIdUsuario());
    }
}
