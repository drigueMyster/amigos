package com.amigos.demo.dao;

import com.amigos.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> fetchPersons() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id)
    {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isPresent()){
           DB.remove(personMayBe.get());
           return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).
                map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate >= 0){
                        update.setId(id);
                        DB.set(indexOfPersonToUpdate, update);
                        return  1;
                    }
                        return  0;
                }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                 .filter(person -> person.getId().equals(id))
                 .findFirst();
    }

}
