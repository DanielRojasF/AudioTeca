
package com.AudioTeca.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotEmpty
    private String nombre;
    private String correoElectronico;
    private String fechaNacimiento; 
    private String telefono;
    private String nacionalidad; 
    @NotEmpty
    private String contrasenna;
 
    public Usuario() {
    }

    public Usuario(String correoElectronico, String contrasenna) {
        this.correoElectronico = correoElectronico;
        this.contrasenna = contrasenna;
    }

    public Usuario(String nombre, String correoElectronico, String fechaNacimiento, String telefono, String nacionalidad, String contrasenna) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad; 
        this.contrasenna = contrasenna;
    }
     
 
    
//    @NotEmpty
//    private String username;
//    
//    @NotEmpty 
//    private String password;
    
    @JoinColumn(name ="id_usuario")
    @OneToMany
    private List<Rol> roles;
    
   
    
}
