package com.fullstack.posteo.model;

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

public class Posteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String empresa;

    
    @Column(nullable = false, length = 100)
    private String puesto;

    @Column(nullable = false, length = 100)
    private String sueldo;

    @Column(nullable = false, length = 100)
    private String expereriencia;

    @Column(nullable = false, length = 100)
    private String modalidad;
    
    @Column(nullable = false, length = 100)
    private String ubicacion;

    @Column(nullable = false, length = 500)
    private String descripcion;
    

}
