package com.cuervo.Parcial.repository;

import com.cuervo.Parcial.model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento,  Long> {}
