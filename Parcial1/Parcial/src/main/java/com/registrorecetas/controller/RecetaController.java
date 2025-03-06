package com.registrorecetas.controller;

import com.registrorecetas.model.Receta;
import com.registrorecetas.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public List<Receta> obtenerTodas() {
        return recetaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Receta> obtenerPorId(@PathVariable Long id) {
        return recetaService.obtenerPorId(id);
    }

    @PostMapping
    public Receta guardarReceta(@RequestBody Receta receta) {
        return recetaService.guardarReceta(receta);
    }

    @DeleteMapping("/{id}")
    public void eliminarReceta(@PathVariable Long id) {
        recetaService.eliminarReceta(id);
    }
}
