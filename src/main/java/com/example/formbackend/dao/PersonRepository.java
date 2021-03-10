package com.example.formbackend.dao;

import com.example.formbackend.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<PersonDto, Long> {
}
