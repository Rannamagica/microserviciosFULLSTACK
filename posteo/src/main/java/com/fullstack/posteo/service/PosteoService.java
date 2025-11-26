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


    public Posteo crearPosteo(Posteo nuevoPosteo) {

        
        Map<String, Object> usuario = usuarioClient.getUsuarioById(nuevoPosteo.getUsuarioId());
        if (usuario == null || usuario.isEmpty()) {
            throw new RuntimeException("El usuario no existe o es inválido");
        }

       
        Map<String, Object> rolMap = (Map<String, Object>) usuario.get("rol");
        if (rolMap == null) {
            throw new RuntimeException("El usuario no tiene rol asignado");
        }

        String nombreRol = rolMap.get("nombre").toString();

        if (!nombreRol.equalsIgnoreCase("RECLUTADOR")) {
            throw new RuntimeException("Acceso denegado: Solo los reclutadores pueden crear posteos");
        }

        
        String nombres = (String) usuario.get("nombres");
        if (nombres == null) {
            throw new RuntimeException("El nombre del reclutador no está disponible");
        }

        nuevoPosteo.getUsuarioId();  // SOLO si tu entidad lo tiene

    
        return repositoryPosteo.save(nuevoPosteo);
    }

    public List<Posteo> TodosLosPosteos(){
        return repositoryPosteo.findAll();
    }

    public Posteo obtenerporid(Long id){
        return repositoryPosteo.findById(id).orElse(null);
    }







    


}
