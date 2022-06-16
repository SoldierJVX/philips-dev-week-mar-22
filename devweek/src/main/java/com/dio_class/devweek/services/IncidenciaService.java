package com.dio_class.devweek.services;

import com.dio_class.devweek.repositories.IncidenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class IncidenciaService {

    private final IncidenciaRepository repository;

    public IncidenciaService(IncidenciaRepository repository) {
        this.repository = repository;
    }
}
