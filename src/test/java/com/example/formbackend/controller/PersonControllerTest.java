package com.example.formbackend.controller;

import com.example.formbackend.dao.PersonRepository;
import com.example.formbackend.dto.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    private final PersonDto testDto = new PersonDto(
            "TestFirst",
            "testLast",
            "test@test.com",
            "Comment text from Test",
            "Test, Category",
            LocalDate.now().toString()
    );

    private final String API_GET_ALL_PERSONS = "/api/v1/person/all";
    private final String API_POST_PERSON = "/api/v1/person/add";
    private final String API_DELETE_PERSON_BY_FIRSTNAME = "/api/v1/person/delete/{firstName}";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void verifyAppIsInitializedFromStart() throws Exception {
        this.mockMvc.perform(get(API_GET_ALL_PERSONS))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void verifyCanAddPersonToDataBase() throws Exception {
        addPersonToDatabase();
        Optional<PersonDto> personDtoOptional = personRepository.findByFirstName(testDto.getFirstName());
        assertThat(personDtoOptional.isPresent());
    }

    @Test
    public void verifyCanDeletePersonByFirstName() throws Exception {
        addPersonToDatabase();
        this.mockMvc.perform(delete(API_DELETE_PERSON_BY_FIRSTNAME, testDto.getFirstName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        Optional<PersonDto> personDtoOptional = personRepository.findByFirstName(testDto.getFirstName());
        assertThat(personDtoOptional.isEmpty());
    }

    private void addPersonToDatabase() throws Exception {
        this.mockMvc.perform(post(API_POST_PERSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testDto)))
                .andExpect(status().isOk());
    }

}
