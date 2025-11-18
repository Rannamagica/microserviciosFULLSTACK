package com.fullstack.posteo.model;

import jakarta.persistence.Entity;
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

    private int sueldo;

    private int tiempo;
}
