package com.example.demo.controller;

import com.example.demo.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PersonController {

    private final List<Person> people = new ArrayList<>(Arrays.asList(
            new Person(1, "Justin", "Reich"),
            new Person(2, "Kathleen", "Weaver"),
            new Person(3, "Casey", "Edwards"),
            new Person(4, "David", "Stephens")
    ));

    private Person getOne(long id) {
        Person foundPerson = null;
        for (Person person : people) {
            if (person.getId() == id) {
                foundPerson = person;
            }
        }
        return foundPerson;
    }


    // TODO: fill in the needed method and create the needed view
    @GetMapping("/people")
    public String allPeople(Model model) {
        model.addAttribute("people", people);
        return "people";
    }

//    @GetMapping("/people/{id}")
    // TODO: fill in the needed method and create the needed view

}
