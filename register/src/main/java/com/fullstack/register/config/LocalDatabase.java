package com.fullstack.register.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fullstack.register.repository.ResgisterRepository;



@Configuration
public class LocalDatabase {
    
   @Bean
   CommandLineRunner inDatabase(ResgisterRepository resgisterRepository){

        return arg ->{

            if(resgisterRepository.count()==0){

                resgisterRepository.save(new com.fullstack.register.model.register(null,"Carlos","fe123@duocuc.cl"));

                System.out.println("Datos iniciales cargados");
            }else{
                System.out.println("ERROR DATOS NO CARGADOS");
            }   
                
               
        };
        
           
    }
}