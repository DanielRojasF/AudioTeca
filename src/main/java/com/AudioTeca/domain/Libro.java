
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
@Table(name="LIBROS")
public class Libro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String audio;
    private String pdf;

    public Libro() {
    }

    public Libro(String titulo, String descripcion, String imagen, String audio, String pdf) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.audio = audio;
        this.pdf = pdf;
    }

    
}
