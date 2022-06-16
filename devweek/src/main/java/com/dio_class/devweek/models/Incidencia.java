package com.dio_class.devweek.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private UUID id;

    private int regiaoId;

    private int mes;

    private int faixaId;

    private int qtdExames;
}
