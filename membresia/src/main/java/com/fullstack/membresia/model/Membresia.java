package com.fullstack.membresia.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Entity
@Table(name = "Posteos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Membresia {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private Long usuarioId; // from microservicio usuario

    @Column(nullable = false, length = 100)
    private String tipo; // Gratis, Estandar, Premium
    
    @Column(nullable = false, length = 100) 
    private LocalDate fechaInicio;
}
