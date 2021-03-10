package com.example.formbackend.service;

import com.example.formbackend.dao.PersonRepository;
import com.example.formbackend.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> getAllPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(PersonDto personDto) {
        personRepository.save(personDto);
    }
}
