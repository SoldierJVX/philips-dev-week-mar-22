package com.dio_class.devweek.controllers;

import com.dio_class.devweek.models.Regiao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegiaoControllerTest {

    private final String URL = "http://localhost:8080/regiao";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RegiaoController regiaoController;

    // Listar os objetos
    @Test
    public void getControllerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                get(URL)).andExpect(status().isOk());
    }

    // Pegar objeto por id
    @Test
    public void getByIdControllerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                get(URL+"/d6ef57f3-fbcf-11ec-99e1-0242ac110002"))
                .andExpect(status().isOk());
    }

    @Test
    public void addNewRegiaoTest() throws Exception {
        Regiao regiao = new Regiao(UUID.fromString("49eda78a-b653-461e-a54d-6abd3bca9ea4"), "Fantasma", new BigInteger("0"));
        this.mockMvc.perform(
                post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(regiao))
        ).andExpect(status().isCreated());
    }

    @Test
    public void deleteByIdRegiaoTest() throws Exception {
        this.mockMvc.perform(
                delete(URL + "/{id}", UUID.fromString("49eda78a-b653-461e-a54d-6abd3bca9ea4").toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    private String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
