package com.fullstack.posteo.webclient;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UsuarioClient {

    private final WebClient webclient;



    public UsuarioClient (@Value("${usuario-service.url}")String usuarioServiceUrl){
        this.webclient= WebClient.builder().baseUrl(usuarioServiceUrl).build();


    }
    public Map<String, Object> getUsuarioById(Long id) {
    return this.webclient.get()
            .uri("/{id}", id)  // Aquí se reemplaza {id} con el valor
            .retrieve()
            .onStatus(status -> status.is4xxClientError(),
                      response -> response.bodyToMono(String.class)
                              .map(body -> new RuntimeException("Usuario invalido ")))
            .bodyToMono(Map.class)
            .block();  // Sincroniza la respuesta

            
    }

    public boolean esReclutador(Long id) {
    try {
        Map usuario = getUsuarioById(id);
        if (usuario == null) return false;

        Map rol = (Map) usuario.get("rol");
        if (rol == null) return false;

        String nombreRol = rol.get("nombre").toString();
        return nombreRol.equalsIgnoreCase("RECLUTADOR");

    } catch (Exception e) {
        return false;
    }
}
}
