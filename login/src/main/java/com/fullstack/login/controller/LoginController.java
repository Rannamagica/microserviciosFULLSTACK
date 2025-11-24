package com.fullstack.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.login.model.Login;
import com.fullstack.login.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "Guardar un registro de login")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Login guardado correctamente",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Login.class))
    ),
    @ApiResponse(responseCode = "400", description = "Datos inválidos",
        content = @Content)
    })
    @PostMapping("/guardar")
    public Login GuardarContacto (@RequestBody Login login) {

        return loginService.GuardarContacto(login);
    }
    
}
