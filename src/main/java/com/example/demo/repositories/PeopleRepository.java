package com.example.demo.repositories;

import com.example.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
}
