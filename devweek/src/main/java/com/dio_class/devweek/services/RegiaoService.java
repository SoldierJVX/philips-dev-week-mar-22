package com.dio_class.devweek.services;

import com.dio_class.devweek.models.Regiao;
import com.dio_class.devweek.repositories.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegiaoService {

    private final RegiaoRepository repository;

    public RegiaoService(RegiaoRepository repository) {
        this.repository = repository;
    }

    public List<Regiao> findAll() {
        return this.repository.findAll();
    }

    public Optional<Regiao> findById(UUID id) {
        return this.repository.findById(id);
    }

    public Regiao save(Regiao regiao) {
        return this.repository.save(regiao);
    }

    public void delete(Regiao regiao) {
        this.repository.delete(regiao);
    }
}
