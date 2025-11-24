package com.microservicios.workenado.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservicios.workenado.dto.UsuarioDTO;
import com.microservicios.workenado.model.Rol;
import com.microservicios.workenado.model.Usuario;
import com.microservicios.workenado.service.ServiceRole;
import com.microservicios.workenado.service.ServiceUsuarios;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    

    @Autowired
    private ServiceUsuarios usuarioService;

    @Autowired
    private ServiceRole roleService;

    @Operation(summary = "Listar todos los usuarios")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuarios encontrados",
        content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = UsuarioDTO.class)))
    ),
    @ApiResponse(responseCode = "204", description = "No existen usuarios registrados",
        content = @Content)
    })
    @GetMapping("/user")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.obetenerUsuarios();
    }

    @Operation(summary = "Obtener la lista de roles disponibles")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Roles encontrados",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Rol.class))
    ),
    @ApiResponse(responseCode = "204", description = "No existen roles registrados",
        content = @Content)
    })
    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> obtenerRoles() {
        List<Rol> roles = roleService.bucarRol();
        return roles.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(roles);
    }


    @Operation(summary = "Crear un nuevo usuario")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Usuario creado correctamente",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class))
    ),
    @ApiResponse(responseCode = "400", description = "Datos inválidos o error al crear el usuario",
        content = @Content(mediaType = "application/json",
            schema = @Schema(example = "El email ya está registrado"))
    )
    })
    @PostMapping("/users")
    public ResponseEntity<?> crearUsuarios(@RequestBody Usuario usuario) {
        try {
            System.out.println("Password recibida: " + usuario.getPassword());

            Long roleId = usuario.getRol().getId();// ayuda

            Usuario nuevoUsuario = usuarioService.crearUsuario(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getNombres(),
                usuario.getApellido(),
                usuario.getTelefono(),
                usuario.getEmail(),
                roleId
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }




    @Operation(summary = "Eliminar usuario por ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito",
        content = @Content(mediaType = "application/json",
            schema = @Schema(example = "Usuario eliminado con éxito"))
    ),
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
        content = @Content(mediaType = "application/json",
            schema = @Schema(example = "El usuario con ID 10 no existe")))
    })
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    @Operation(summary = "Buscar usuario por ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuario encontrado",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class))
    ),
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
        content = @Content)
    })
    @GetMapping("/user/{id}")
    public ResponseEntity<?> buscarPorid(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.buscarPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Actualizar un usuario por ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class))
    ),
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
        content = @Content(mediaType = "application/json",
            schema = @Schema(example = "El usuario con ID 10 no existe"))
    ),
    @ApiResponse(responseCode = "400", description = "Datos inválidos",
        content = @Content)
    })
    @PutMapping("/users/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        try {
            Usuario actualizado = usuarioService.actualizarUsuario(id, usuarioActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Operation(summary = "Verificar si un usuario existe por ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Resultado de la verificación",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class),
            examples = {
                @ExampleObject(name = "Existe", value = "true"),
                @ExampleObject(name = "No existe", value = "false")
            }
        )
    )
    })
    @GetMapping("/user/{id}/existe")
    public ResponseEntity<Boolean> existeUsuario(@PathVariable Long id) {
        boolean existe = usuarioService.buscarPorId(id) != null;
        return ResponseEntity.ok(existe);
    }
}
