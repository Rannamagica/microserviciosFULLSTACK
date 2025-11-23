package com.fullstack.posteo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.posteo.model.Posteo;
import com.fullstack.posteo.service.PosteoService;

@RestController
@RequestMapping("/api/posteo")
public class PosteoController {

    @Autowired
    private PosteoService posteoService;

    @PostMapping("/crear")
    public Posteo crearPosteo(
            @RequestParam Long usuarioId,
            @RequestParam String empresa,
            @RequestParam String puesto,
            @RequestParam String sueldo,
            @RequestParam String experiencia,
            @RequestParam String modalidad,
            @RequestParam String ubicacion,
            @RequestParam String descripcion
    ) {
        return posteoService.crearPosteo(
                usuarioId,
                empresa,
                puesto,
                sueldo,
                experiencia,
                modalidad,
                ubicacion,
                descripcion
        );
    }


    // Obtener todos los posteos
    @GetMapping("/lista")
    public List<Posteo> obtenerTodos() {
        return posteoService.TodosLosPosteos();
    }

    // Obtener un posteo por ID
    @GetMapping("/{id}")
    public Posteo obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerporid(id);
    }

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
