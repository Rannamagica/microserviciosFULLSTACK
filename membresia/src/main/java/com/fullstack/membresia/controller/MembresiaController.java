package com.fullstack.membresia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.membresia.model.Membresia;
import com.fullstack.membresia.service.MembresiaService;





@RestController
@RequestMapping("/api/membresia")
public class MembresiaController {

    @Autowired
    private MembresiaService service;

    @PostMapping("/asignar")
    public Membresia asignar(
            @RequestParam Long usuarioId,
            @RequestParam String tipo // Gratis - Estandar - Premium
    ) {
        return service.asignarMembresia(usuarioId, tipo);
    }

    @GetMapping("/usuario/{usuarioId}")
    public Membresia obtener(@PathVariable Long usuarioId) {
        return service.obtenerMembresia(usuarioId);
    }
}
