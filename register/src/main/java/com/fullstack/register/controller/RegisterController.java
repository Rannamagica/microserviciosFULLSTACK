package com.fullstack.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.register.model.register;
import com.fullstack.register.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Operation(summary = "Guardar un registro de usuario")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Registro guardado correctamente",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = register.class))
    ),
    @ApiResponse(responseCode = "400", description = "Datos inválidos",
        content = @Content)
    })
    @PostMapping("/guardar")
    public register GuardarContacto (register Register) {

        return registerService.GuardarContacto(Register);
    }
}
