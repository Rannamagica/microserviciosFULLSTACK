package com.fullstack.membresia.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fullstack.membresia.model.Membresia;
import com.fullstack.membresia.repository.MembresiaRepository;

@Configuration
public class LoadDataBase {


    @Bean
    CommandLineRunner inDatabase(MembresiaRepository contarep){

        return arg ->{

            if(contarep.count()==0){
                
                contarep.save(new Membresia(
                    null,
                    1L,
                    "Gratis",
                    LocalDate.of(2023, 10, 15)
            ));

            contarep.save(new Membresia(
                    null,
                    2L,
                    "Estandar",
                    LocalDate.of(2023, 11, 1)
            ));

            contarep.save(new Membresia(
                    null,
                    3L,
                    "Premium",
                    LocalDate.of(2023, 12, 5)
            ));
            
            System.out.println("Datos iniciales cargados");


            }else{
                System.out.println("ERROR DATOS NO CARGADOS");
            }
        };
    }
}
