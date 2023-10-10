package com.learn.lld.cache;

import com.learn.lld.cache.core.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    private PersonDAO personDAO;

    @Cacheable
    public Person getPerson(String key) {
        return personDAO.getPerson(key);
    }

    public Person createPerson(Person person) {
        personDAO.addPerson(person);
        return person;
    }
}
