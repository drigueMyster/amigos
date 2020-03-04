package com.amigos.demo.service;

import com.amigos.demo.dao.PersonDao;
import com.amigos.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public  int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
