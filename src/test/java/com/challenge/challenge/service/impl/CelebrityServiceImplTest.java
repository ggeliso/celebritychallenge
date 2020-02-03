package com.challenge.challenge.service.impl;

import com.challenge.challenge.repository.IPeopleRepository;
import com.challenge.challenge.service.ICelebrityService;
import com.challenge.challenge.service.config.LoaderTeam;
import com.challenge.challenge.service.config.Person;
import com.challenge.challenge.service.config.Team;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CelebrityServiceImplTest {

    @Mock
    private LoaderTeam loaderTeam;

    @InjectMocks
    private ICelebrityService celebrityService = new CelebrityServiceImpl();

    @BeforeEach
    void setUp(){

        List<Person> personList = Arrays.asList(
                new Person(1L, "Gustavo", false),
                new Person(2L, "Gelis", false),
                new Person(3L, "Osorio", false),
                new Person(4L, "Sandra", true),
                new Person(5L, "Soto", false),
                new Person(6L, "Fuentes", false),
                new Person(7L, "Gabi", false),
                new Person(8L, "Susa", false),
                new Person(9L, "Sofia", false)
        );

        String name = "Gustavo";

        Team team = new Team(1000L, "Composite");
        for (Person person:
                personList) {
            team.addMember(person);

        }

        when (loaderTeam.loadPerson()).thenReturn(personList);
        when (loaderTeam.loadTeam(personList)).thenReturn(team);

    }

    @Test
    void getCelebrityNotExist() {

        String name = "AnyMember";
        assertEquals(Optional.empty(), celebrityService.getCelebrity(name));
    }

    @Test
    void getCelebrity() {

        String name = "Sandra";
        assertEquals("I'm here my name is: " + name + ", and I'm the celebrity", celebrityService.getCelebrity(name).get());
    }

    @Test
    void getCelebrityIsNot() {

        String name = "Gustavo";
        assertEquals("This member: " + name + " is not the celebrity", celebrityService.getCelebrity(name).get());
    }
}