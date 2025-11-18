package com.fullstack.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.login.model.Login;
import com.fullstack.login.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/guardar")
    public Login GuardarContacto (@RequestBody Login login) {

        return loginService.GuardarContacto(login);
    }
    
}
