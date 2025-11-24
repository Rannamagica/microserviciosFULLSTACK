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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;





@RestController
@RequestMapping("/api/membresia")
public class MembresiaController {

    @Autowired
    private MembresiaService service;



    @Operation(summary = "Asignar una membresía a un usuario")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Membresía asignada correctamente",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Membresia.class))
    ),
    @ApiResponse(responseCode = "400", description = "Tipo de membresía inválido",
        content = @Content),
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
        content = @Content)
    })
    @PostMapping("/asignar")
    public Membresia asignar(
            @RequestParam Long usuarioId,
            @RequestParam String tipo // Gratis - Estandar - Premium
    ) {
        return service.asignarMembresia(usuarioId, tipo);
    }




    @Operation(summary = "Obtener la membresía de un usuario")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Membresía encontrada",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Membresia.class))
    ),
    @ApiResponse(responseCode = "404", description = "No existe membresía para este usuario",
        content = @Content)
    })
    @GetMapping("/usuario/{usuarioId}")
    public Membresia obtener(@PathVariable Long usuarioId) {
        return service.obtenerMembresia(usuarioId);
    }
}
