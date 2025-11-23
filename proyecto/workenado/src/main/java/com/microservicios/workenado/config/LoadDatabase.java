package com.microservicios.workenado.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservicios.workenado.model.Rol;
import com.microservicios.workenado.model.Usuario;
import com.microservicios.workenado.repository.RoleRepository;
import com.microservicios.workenado.repository.UsuarioRepository;

@Configuration
public class LoadDatabase {
    
    @Bean
    CommandLineRunner iniDatabase(RoleRepository roleRepo, UsuarioRepository userRepo){

        return arg ->{

            if(roleRepo.count()==0 && userRepo.count()==0){
                    

                    // estos son los reles que se van a ocupar
                    Rol admin = new Rol();
                    admin.setNombre("Administrador ");
                    roleRepo.save(admin);

                    Rol user= new Rol();
                    user.setNombre("Cliente");
                    roleRepo.save(user);
                

                    Rol Rec= new Rol();
                    Rec.setNombre("Reclutador");
                    roleRepo.save(Rec);

                    
                    

                    userRepo.save(new Usuario(null,"felipe","123","fege@123","fernando","villalobo","+56933993853",admin));
                    userRepo.save(new Usuario(null,"juan","321","dasCadez@123","gabriel","jorquera","+56933993855",user));
                    userRepo.save(new Usuario(null,"pepe","567","pera@123","estevan","torres","+56933993851",Rec));

                    //---------------------------------------------------------------------------------------------------------------------------------------------
                    

                    System.out.println("Datos iniciales cargados ");


            }else{

                System.out.println("Datos ya existen. no realizo carga");
            }



        };


    }
}
