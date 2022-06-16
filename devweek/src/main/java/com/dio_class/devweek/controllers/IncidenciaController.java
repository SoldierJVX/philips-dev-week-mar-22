package com.dio_class.devweek.controllers;

import com.dio_class.devweek.models.Incidencia;
import com.dio_class.devweek.repositories.IncidenciaRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/incidencia")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IncidenciaController {

    private final IncidenciaRepository service;

    public IncidenciaController(IncidenciaRepository service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Incidencias")
    public ResponseEntity<?> findAllIncidencias(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get one Incidência")
    public ResponseEntity<Incidencia> findIncidenciasById(@PathVariable UUID id){
        Optional<Incidencia> incidenciaOptional = service.findById(id);
        if (incidenciaOptional.isPresent()){
            return new ResponseEntity<>(incidenciaOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Save one Incidência")
    public ResponseEntity<Object> saveRegiao(@RequestBody Incidencia incidencia){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(incidencia));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one Incidência")
    public ResponseEntity<Object> updateRegiao(@PathVariable(value = "id") UUID id,
                                               @RequestBody Incidencia incidencia){
        Optional<Incidencia> incidenciaOptional = service.findById(id);
        if(!incidenciaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incidencia not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.save(incidencia));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one Incidencia")
    public ResponseEntity<Object> deleteRegiao(@PathVariable(value = "id") UUID id){
        Optional<Incidencia> incidenciaOptional = service.findById(id);
        if(!incidenciaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incidencia not found.");
        }
        service.delete(incidenciaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Incidencia deleted.");
    }

}
