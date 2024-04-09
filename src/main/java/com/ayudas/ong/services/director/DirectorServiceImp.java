package com.ayudas.ong.services.director;

import org.springframework.stereotype.Service;

import com.ayudas.ong.repositories.DirectorRepository;
import com.ayudas.ong.repositories.entities.Director;
import com.ayudas.ong.services.DirectorServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DirectorServiceImp implements DirectorServices {

    public DirectorRepository directorRepository;

    public void guardar(Director director) {
        this.directorRepository.save(director);
    }
    
}
