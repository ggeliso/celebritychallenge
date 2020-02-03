package com.challenge.challenge.service.config;

import com.challenge.challenge.model.People;
import com.challenge.challenge.repository.IPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoaderTeam {

    @Autowired
    IPeopleRepository iPeopleRepository;

    public List<Person> loadPerson(){

        Iterable<People> people = iPeopleRepository.findAll();

        List<Person> personList = new ArrayList<Person>();
        for (People people1:
             people) {
            Person person = new Person(people1.getId(), people1.getName(), people1.isCelebrity());
            personList.add(person);
        }
        return personList;
    }

    public Team loadTeam(List<Person> personList){
        Team team = new Team(1000L, "Composite");

        for (Person person:
                personList) {
            team.addMember(person);

        }

        return team;
    }
}
