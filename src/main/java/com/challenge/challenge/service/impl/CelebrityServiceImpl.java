package com.challenge.challenge.service.impl;

import com.challenge.challenge.model.People;
import com.challenge.challenge.repository.IPeopleRepository;
import com.challenge.challenge.service.ICelebrityService;
import com.challenge.challenge.service.config.LoaderTeam;
import com.challenge.challenge.service.config.Member;
import com.challenge.challenge.service.config.Person;
import com.challenge.challenge.service.config.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelebrityServiceImpl implements ICelebrityService {

    @Autowired
    IPeopleRepository iPeopleRepository;

    @Autowired
    LoaderTeam loaderTeam;

    @Override
    public Optional<String> getCelebrity(String name){

        List<Person> personList = loaderTeam.loadPerson();

        Team team = loaderTeam.loadTeam(personList);

        Optional<String> result = findCelebrity(team, name);

        return result;

    }

    private Optional<String> findCelebrity(Team team, String name) {

        Member member =  memberExist(team, name);
        String result = "";

        if(member == null){
            return Optional.empty();
        }

        if(((Person)member).isCelebrity() && member.getName().equalsIgnoreCase(name)){
            result = "I'm here my name is: " + member.getName() + ", and I'm the celebrity";
        } else {
            result = "This member: " + name + " is not the celebrity";
        }
        return Optional.ofNullable(result);
    }

    private Member memberExist(Team team, String name){
        return team.getMembers().stream()
                .filter(singlePerson -> singlePerson.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);


    }

}
