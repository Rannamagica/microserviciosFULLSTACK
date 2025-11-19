package com.fullstack.login.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fullstack.login.model.Login;
import com.fullstack.login.repository.LoginRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner inDatabase(LoginRepository contarep){

        return arg ->{

            if(contarep.count()==0){
                
                contarep.save(new Login(null,"Juan","Juan123@hola.com"));
                contarep.save(new Login(null,"Felipe","felipe123@hola.com"));

                System.out.println("Datos iniciales cargados");


            }else{
                System.out.println("ERROR DATOS NO CARGADOS");
            }
        };
    }
}
