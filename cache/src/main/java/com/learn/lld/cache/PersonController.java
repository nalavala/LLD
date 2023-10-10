package com.learn.lld.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") String id) {
        return  personService.getPerson(id);
    }
}
