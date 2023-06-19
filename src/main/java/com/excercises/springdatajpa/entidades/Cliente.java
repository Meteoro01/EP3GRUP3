package com.excercises.springdatajpa.entidades;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true)
    private String correo;

    @Column(unique = true)
    private String celular;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    public LocalDateTime fechaModificacion = null ;

    
    // Resto de los atributos y métodos
}
