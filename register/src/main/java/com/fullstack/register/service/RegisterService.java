package com.fullstack.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.register.repository.ResgisterRepository;

@Service
public class RegisterService {

    
    @Autowired
    private ResgisterRepository registerRepository;

    public com.fullstack.register.model.register GuardarContacto (com.fullstack.register.model.register register){
        if (register.getNombre() == null || register.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        return registerRepository.save(register);
    }
}
