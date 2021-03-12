package com.example.formbackend.controller;

import com.example.formbackend.dto.PersonDto;
import com.example.formbackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Person controller to handle requests method
 */

@CrossOrigin("*") // To make requests acceptable with front end on localhost
@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/add")
    public void addNewPerson(@RequestBody PersonDto personDto) {
        personService.addNewPerson(personDto);
    }

    @Transactional
    @DeleteMapping("/delete/{firstName}")
    public void deletePerson(@PathVariable String firstName) {
        personService.deletePerson(firstName);
    }
}
