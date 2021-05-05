package com.example.demo.controller;

import com.example.demo.repositories.PeopleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PersonController {

//    private final List<Person> people = new ArrayList<>(Arrays.asList(
//            new Person(1, "Justin", "Reich"),
//            new Person(2, "Kathleen", "Weaver"),
//            new Person(3, "Casey", "Edwards"),
//            new Person(4, "David", "Stephens")
//    ));
//
//    private Person getOne(long id) {
//        Person foundPerson = null;
//        for (Person person : people) {
//            if (person.getId() == id) {
//                foundPerson = person;
//            }
//        }
//        return foundPerson;
//    }

    private final PeopleRepository peopleDao;

    public PersonController(PeopleRepository peopleDao) {
        this.peopleDao = peopleDao;
    }


    // TODO: fill in the needed method and create the needed view
    @GetMapping("/people")
    public String allPeople(Model model) {
        model.addAttribute("person", peopleDao.findAll());
        return "/person/people";
    }

    // TODO: fill in the needed method and create the needed view
    @GetMapping("/people/{id}")
    public String editPerson(@PathVariable long id, Model model) {
        model.addAttribute("person", peopleDao.getOne(id));
        return "/person/edit";
    }


}
