package com.fullstack.posteo.model;

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

public class Posteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Nombre de la empresa que ofrece el trabajo", example = "Tech Solutions")
    private String empresa;

    
    @Column(nullable = false, length = 100)
    @Schema(description = "Puesto de trabajo ofrecido", example = "Desarrollador Full Stack")
    private String puesto;

    @Column(nullable = false, length = 100)
    @Schema(description = "Sueldo ofrecido para el puesto", example = "60000 USD")
    private String sueldo;

    @Column(nullable = false, length = 100)
    @Schema(description = "Experiencia requerida para el puesto", example = "3 años")
    private String expereriencia;

    @Column(nullable = false, length = 100)
    @Schema(description = "Modalidad de trabajo: Presencial, Remoto, Híbrido", example = "Remoto")
    private String modalidad;
    
    @Column(nullable = false, length = 100)
    @Schema(description = "Ubicación del trabajo", example = "Ciudad de México")
    private String ubicacion;

    @Column(nullable = false, length = 500)
    @Schema(description = "Descripción detallada del puesto de trabajo", example = "Responsable de desarrollar y mantener aplicaciones web...") 
    private String descripcion;

    
    @Column(nullable = false)
    @Schema(description = "Identificador unico del usuario que creó el posteo", example = "1")  
    private Long usuarioId;

    

}
