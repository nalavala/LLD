package com.learn.lld.cache;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonDAO {

    private Map<String, Person> persons = new HashMap<>();

    public void addPerson(Person person) {
        persons.put(person.getId(), person);

    }
    public Person getPerson(String id) {
        return persons.get(id);
    }

}
