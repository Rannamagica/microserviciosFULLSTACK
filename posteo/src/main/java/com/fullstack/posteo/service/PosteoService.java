package com.fullstack.posteo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.posteo.model.Posteo;
import com.fullstack.posteo.repository.PosteoRepository;

@Service
public class PosteoService {


    @Autowired
    private PosteoRepository repositoryPosteo;

    public void eliminarPost(Long postId){

        Posteo posteo = repositoryPosteo.findById(postId)
            .orElseThrow(()-> new RuntimeException("post no encontrado " + postId));
        repositoryPosteo.delete(posteo);
    }


    public Posteo crearPosteo(String empresa ,String puesto , String sueldo , String experiencia , String modalidad , String ubicacion , String descripcion){
      
        Posteo post = new Posteo();
        post.setEmpresa(empresa);
        post.setPuesto(puesto);
        post.setSueldo(sueldo);
        post.setExpereriencia(experiencia);
        post.setModalidad(modalidad);
        post.setUbicacion(ubicacion);
        post.setDescripcion(descripcion);

        return repositoryPosteo.save(post);

    }



    


}
