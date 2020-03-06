package com.amigos.demo.dao;

import com.amigos.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("databaseRepo")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> fetchPersons() {
        List<Person> liste = new ArrayList<>();
        liste.add(new Person(UUID.randomUUID(), "This is person from databse"));
        return liste;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }
}
