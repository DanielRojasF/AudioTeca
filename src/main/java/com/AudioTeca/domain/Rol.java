
package com.AudioTeca.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idRol; // hibernate lo transforma id_cliente
    
    
    
    @NotEmpty
    private String nombre;
    @Column(name = "id_usuario")
    private Long idUsuario;

    public Rol() {
    }
    
//    public Rol(String nombre, Long idUsuario) {
//        this.nombre = nombre;
//        this.idUsuario = idUsuario;
//    }

    

  

    
    
}
