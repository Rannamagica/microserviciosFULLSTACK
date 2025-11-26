package com.fullstack.posteo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fullstack.posteo.model.Posteo;
import com.fullstack.posteo.repository.PosteoRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner inDatabase(PosteoRepository contarep){

        return arg ->{

             if (contarep.count() == 0) {
             contarep.save(new Posteo(
                    null,
                    "Tech Solutions",
                    "Desarrollador Full Stack",
                    "1500000 CLP",
                    "3 años",
                    "Remoto",
                    "Santiago",
                    "Desarrollo y mantenimiento de aplicaciones web.",
                    1L  // usuarioId (reclutador)
            ));

            contarep.save(new Posteo(
                    null,
                    "Finanzas Pro",
                    "Analista Contable",
                    "1200000 CLP",
                    "2 años",
                    "Presencial",
                    "Providencia",
                    "Responsable de análisis financiero y conciliaciones.",
                    2L
            ));

            contarep.save(new Posteo(
                    null,
                    "MarketNow",
                    "Diseñador UX/UI",
                    "1300000 CLP",
                    "1 año",
                    "Híbrido",
                    "Las Condes",
                    "Diseño de interfaces y experiencia de usuario.",
                    3L
            ));
            
            System.out.println("Datos iniciales cargados");


            }else{
                System.out.println("ERROR DATOS NO CARGADOS");
            
            }
        };
    }
}
