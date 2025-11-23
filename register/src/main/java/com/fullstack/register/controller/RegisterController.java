package com.fullstack.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.register.model.register;
import com.fullstack.register.service.RegisterService;



@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "")
public class RegisterController {

    @Autowired
    private RegisterService registerService;


    @PostMapping("/guardar")
    public register GuardarContacto (register Register) {

        return registerService.GuardarContacto(Register);
    }
}
