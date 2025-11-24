package com.fullstack.membresia.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Identificador unico de la membresia", example = "1")
    private Long id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Identificador unico del usuario asociado a la membresia", example = "1")
    private Long usuarioId; // from microservicio usuario

    @Column(nullable = false, length = 100)
    @Schema(description = "Tipo de membresia: Gratis, Estandar, Premium", example = "Premium")
    private String tipo; // Gratis, Estandar, Premium
    
    @Column(nullable = false, length = 100)
    @Schema(description = "Fecha de inicio de la membresia", example = "2023-10-15")
    private LocalDate fechaInicio;
}
