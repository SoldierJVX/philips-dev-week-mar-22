package com.dio_class.devweek.controllers;

import com.dio_class.devweek.models.Regiao;
import com.dio_class.devweek.services.RegiaoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@OpenAPIDefinition(
        info = @Info(
                title = "API Philips Dev Week - Março 2022",
                version = "1.0",
                description = "API REST de Philips Dev Week",
                contact = @Contact(
                        name = "João Silva",
                        email = "jv_rss@hotmail.com"
                ),
                license = @License(
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html",
                        name = "Apache 2.0"
                )
        )
)
@RestController
@RequestMapping("/regiao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegiaoController {

    private final RegiaoService service;

    public RegiaoController(RegiaoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Região")
    public ResponseEntity<?> findAllRegioes(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get one Região")
    public ResponseEntity<Regiao> findRegioesById(@PathVariable UUID id){
        Optional<Regiao> regiaoOptional = service.findById(id);
        if (regiaoOptional.isPresent()){
            return new ResponseEntity<>(regiaoOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Save one Regiao")
    public ResponseEntity<Object> saveRegiao(@RequestBody Regiao regiao){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(regiao));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update one Regiao")
    public ResponseEntity<Object> updateRegiao(@PathVariable(value = "id") UUID id,
                                               @RequestBody Regiao regiao){
        Optional<Regiao> regiaoOptional = service.findById(id);
        if(!regiaoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Região not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.save(regiao));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete one Regiao")
    public ResponseEntity<Object> deleteRegiao(@PathVariable(value = "id") UUID id){
        Optional<Regiao> regiaoOptional = service.findById(id);
        if(!regiaoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Região not found.");
        }
        service.delete(regiaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Região deleted.");
    }

}
