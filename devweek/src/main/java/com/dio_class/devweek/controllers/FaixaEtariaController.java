package com.dio_class.devweek.controllers;

import com.dio_class.devweek.models.FaixaEtaria;
import com.dio_class.devweek.repositories.FaixaEtariaRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/faixaetaria")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FaixaEtariaController {

    private final FaixaEtariaRepository service;

    public FaixaEtariaController(FaixaEtariaRepository service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Faixas Etarias")
    public ResponseEntity<?> findAllFaixaEtaria(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get one Faixa Etaria")
    public ResponseEntity<FaixaEtaria> findFaixaEtariaById(@PathVariable UUID id){
        Optional<FaixaEtaria> faixaEtariaOptional = service.findById(id);
        if (faixaEtariaOptional.isPresent()){
            return new ResponseEntity<>(faixaEtariaOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Save one Faixa Etaria")
    public ResponseEntity<Object> saveRegiao(@RequestBody FaixaEtaria faixaEtaria){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(faixaEtaria));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one Faixa Etaria")
    public ResponseEntity<Object> updateRegiao(@PathVariable(value = "id") UUID id,
                                               @RequestBody FaixaEtaria faixaEtaria){
        Optional<FaixaEtaria> faixaEtariaOptional = service.findById(id);
        if(!faixaEtariaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faixa Etaria not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.save(faixaEtaria));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one Incidencia")
    public ResponseEntity<Object> deleteRegiao(@PathVariable(value = "id") UUID id){
        Optional<FaixaEtaria> faixaEtariaOptional = service.findById(id);
        if(!faixaEtariaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faixa Etaria not found.");
        }
        service.delete(faixaEtariaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Faixa Etaria deleted.");
    }

}
