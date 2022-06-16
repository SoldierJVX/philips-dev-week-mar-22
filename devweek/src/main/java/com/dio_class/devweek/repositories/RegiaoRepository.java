package com.dio_class.devweek.repositories;

import com.dio_class.devweek.models.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, UUID> {
}
