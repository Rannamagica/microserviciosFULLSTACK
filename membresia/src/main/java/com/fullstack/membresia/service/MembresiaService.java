package com.fullstack.membresia.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.membresia.model.Membresia;
import com.fullstack.membresia.repository.MembresiaRepository;
import com.fullstack.membresia.webclient.UsuarioClient;


@Service
public class MembresiaService {
    @Autowired
    private MembresiaRepository repo;

    @Autowired
    private UsuarioClient usuarioClient;

    public Membresia asignarMembresia(Long usuarioId, String tipo) {

        if (!usuarioClient.existeUsuario(usuarioId)) {
            throw new RuntimeException("El usuario no existe: " + usuarioId);
        }

        // Ver si ya tiene membresía
        Optional<Membresia> existente = repo.findById(usuarioId);

        Membresia memb = existente.orElse(new Membresia());
        memb.setUsuarioId(usuarioId);
        memb.setTipo(tipo);
        memb.setFechaInicio(LocalDate.now());

        return repo.save(memb);
    }

    // Consultar membresía actual
    public Membresia obtenerMembresia(Long usuarioId) {
        return repo.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("El usuario no tiene membresía"));
    }
}
