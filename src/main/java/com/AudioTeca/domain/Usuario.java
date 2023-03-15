
package com.AudioTeca.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String usuario;
    private String correoElectronico;
    private String fechaNacimiento;
    private String telefono;
    private String nacionalidad;
    private String contrasenna;

    public Usuario() {
    }

    public Usuario(String correoElectronico, String contrasenna) {
        this.correoElectronico = correoElectronico;
        this.contrasenna = contrasenna;
    }

    public Usuario(String usuario, String correoElectronico, String fechaNacimiento, String telefono, String nacionalidad, String contrasenna) {
        this.usuario = usuario;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.contrasenna = contrasenna;
    }
   
    
}
