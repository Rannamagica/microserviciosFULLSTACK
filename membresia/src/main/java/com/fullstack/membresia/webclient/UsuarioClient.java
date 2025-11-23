package com.fullstack.membresia.webclient;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UsuarioClient {

    private final WebClient webClient;

    // Constructor: recibe la URL del microservicio de usuarios
    public UsuarioClient(@Value("${usuario-service.url}") String usuarioServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(usuarioServiceUrl)
                .build();
    }

    // Verifica si el usuario existe haciendo GET /{id}
    public boolean existeUsuario(Long id) {
        try {
            Map usuario = webClient.get()
                    .uri("/{id}", id)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return usuario != null; // Existe

        } catch (Exception e) {
            return false; // No existe o hubo error
        }
    }

    // Obtiene datos del usuario si necesitas más adelante
    public Map getUsuario(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

}
