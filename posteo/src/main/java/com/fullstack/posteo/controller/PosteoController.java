package com.fullstack.posteo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.posteo.model.Posteo;
import com.fullstack.posteo.service.PosteoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/posteo")
public class PosteoController {

    @Autowired
    private PosteoService posteoService;




    @Operation(summary = "Crear un nuevo posteo de trabajo")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Posteo creado correctamente",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Posteo.class))
    ),
    @ApiResponse(responseCode = "400", description = "Datos inválidos",
        content = @Content),
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
        content = @Content)
    })
    @PostMapping("/crear")
    public ResponseEntity<?> crearPosteo(@RequestBody Posteo nuevoPosteo) {

        try {
            Posteo creado = posteoService.crearPosteo(nuevoPosteo);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of("error", e.getMessage())
            );
        }
    }


 
    @Operation(summary = "Obtener la lista de todos los posteos")
    @ApiResponses(value = {
    @ApiResponse(
        responseCode = "200",
        description = "Posteos encontrados",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Posteo.class)
        )
    ),
    @ApiResponse(
        responseCode = "204",
        description = "No existen posteos disponibles",
        content = @Content
    )
    })   // Obtener todos los posteos
    @GetMapping("/lista")
    public List<Posteo> obtenerTodos() {
        return posteoService.TodosLosPosteos();
    }


    @Operation(summary = "Obtener un posteo por su ID")
    @ApiResponses(value = {
    @ApiResponse(
        responseCode = "200",
        description = "Posteo encontrado",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Posteo.class)
        )
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Posteo no encontrado",
        content = @Content
    )
    })
    @GetMapping("/{id}")
    public Posteo obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerporid(id);
    }

    @Operation(summary = "Eliminar un posteo por su ID")
    @ApiResponses(value = {
    @ApiResponse(
        responseCode = "200",
        description = "Posteo eliminado correctamente",
        content = @Content(mediaType = "application/json")
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Posteo no encontrado",
        content = @Content
    )
    })
    // Eliminar un posteo por ID
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPost(@PathVariable Long id) {
        posteoService.eliminarPost(id);
        return "Posteo eliminado correctamente. ID: " + id;
    }




/*| Acción       | Método | URL                         |
| -------------- | ------ | --------------------------- |
| Crear post     | POST   | `/api/posteo/crear`         |
| Listar posteos | GET    | `/api/posteo/lista`         |
| Obtener por ID | GET    | `/api/posteo/{id}`          |
| Eliminar       | DELETE | `/api/posteo/eliminar/{id}` |
 */
}
