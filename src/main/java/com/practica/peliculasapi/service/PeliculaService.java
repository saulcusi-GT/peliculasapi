package com.practica.peliculasapi.service;

import com.practica.peliculasapi.entity.Pelicula;
import com.practica.peliculasapi.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> buscarPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula actualizarPelicula(Long id, Pelicula peliculaActualizada) {
        return peliculaRepository.findById(id)
                .map(pelicula -> {
                    pelicula.setTitulo(peliculaActualizada.getTitulo());
                    pelicula.setDirector(peliculaActualizada.getDirector());
                    pelicula.setAnioLanzamiento(peliculaActualizada.getAnioLanzamiento());
                    pelicula.setGenero(peliculaActualizada.getGenero());
                    pelicula.setSinopsis(peliculaActualizada.getSinopsis());
                    return peliculaRepository.save(pelicula);
                })
                .orElse(null);
    }

    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}