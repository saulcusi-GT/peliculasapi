package com.practica.peliculasapi.controller;

import com.practica.peliculasapi.entity.Pelicula;
import com.practica.peliculasapi.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaService.listarPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> obtenerPelicula(@PathVariable Long id) {
        return peliculaService.buscarPorId(id);
    }

    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.guardarPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id,
                                       @RequestBody Pelicula pelicula) {
        return peliculaService.actualizarPelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
    }
}