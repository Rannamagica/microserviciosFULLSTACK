package com.fullstack.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.login.model.Login;
import com.fullstack.login.repository.LoginRepository;

@Service
public class LoginService {


    @Autowired
    private LoginRepository loginRepository;

    public Login GuardarContacto (Login login){
        if (login.getNombre() == null || login.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        return loginRepository.save(login);
    }
}
