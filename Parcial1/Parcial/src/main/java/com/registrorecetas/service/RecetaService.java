package com.cuervo.Parcial.service;


import com.cuervo.Parcial.model.Evento;
import com.cuervo.Parcial.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    @Transactional
    public List<Evento> findAllEventos() {
        return (List<Evento>) eventoRepository.findAll();
    }


    @Transactional
    public Optional<Evento> findEventoById(Long id) {
        return eventoRepository.findById(id);
    }

    @Transactional
    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }


    @Transactional
    public void eliminarEvento(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new EntityNotFoundException("Evento no encontrado con ID: " + id);
        }
        eventoRepository.deleteById(id);
    }

    @Transactional
    public Evento actualizarEvento(Long id, Evento eventoActualizado) {
        return eventoRepository.findById(id)
                .map(eventoExistente -> {
                    // Actualizar campos
                    eventoExistente.setNombre(eventoActualizado.getNombre());
                    eventoExistente.setDescripcion(eventoActualizado.getDescripcion());
                    eventoExistente.setFechaIniciacion(eventoActualizado.getFechaIniciacion());
                    eventoExistente.setEstado(eventoActualizado.getEstado());


                    return eventoRepository.save(eventoExistente);
                })
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado con ID: " + id));
    }


}