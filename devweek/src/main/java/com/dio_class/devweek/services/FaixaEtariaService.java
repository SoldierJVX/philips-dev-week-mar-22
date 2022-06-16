package com.dio_class.devweek.services;

import com.dio_class.devweek.repositories.FaixaEtariaRepository;
import org.springframework.stereotype.Service;

@Service
public class FaixaEtariaService {

    private final FaixaEtariaRepository repository;

    public FaixaEtariaService(FaixaEtariaRepository repository) {
        this.repository = repository;
    }
}
