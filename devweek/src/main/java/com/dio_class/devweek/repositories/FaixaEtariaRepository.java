package com.dio_class.devweek.repositories;

import com.dio_class.devweek.models.FaixaEtaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FaixaEtariaRepository extends JpaRepository<FaixaEtaria, UUID> {
}
