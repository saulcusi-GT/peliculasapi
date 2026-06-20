package com.practica.peliculasapi.repository;

import com.practica.peliculasapi.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}