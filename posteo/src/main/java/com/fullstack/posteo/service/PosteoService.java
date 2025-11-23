package com.fullstack.posteo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.posteo.model.Posteo;
import com.fullstack.posteo.repository.PosteoRepository;
import com.fullstack.posteo.webclient.UsuarioClient;

@Service
public class PosteoService {


    @Autowired
    private PosteoRepository repositoryPosteo;

    @Autowired
    private UsuarioClient usuarioClient;


    public void eliminarPost(Long postId){

        Posteo posteo = repositoryPosteo.findById(postId)
            .orElseThrow(()-> new RuntimeException("post no encontrado " + postId));
        repositoryPosteo.delete(posteo);
    }


    public Posteo crearPosteo(
            Long usuarioId,
            String empresa,
            String puesto,
            String sueldo,
            String experiencia,
            String modalidad,
            String ubicacion,
            String descripcion
    ) {

        // Obtener usuario desde microservicio usuario
        Map<String, Object> usuario = usuarioClient.getUsuarioById(usuarioId);

        // Si el usuario no existe → error
        if (usuario == null || usuario.isEmpty()) {
            throw new RuntimeException("El usuario no existe: " + usuarioId);
        }

        Posteo post = new Posteo();
        post.setUsuarioId(usuarioId);
        post.setEmpresa(empresa);
        post.setPuesto(puesto);
        post.setSueldo(sueldo);
        post.setExpereriencia(experiencia);
        post.setModalidad(modalidad);
        post.setUbicacion(ubicacion);
        post.setDescripcion(descripcion);

        return repositoryPosteo.save(post);
    }

    public List<Posteo> TodosLosPosteos(){
        return repositoryPosteo.findAll();
    }

    public Posteo obtenerporid(Long id){
        return repositoryPosteo.findById(id).orElse(null);
    }







    


}
