package com.challenge.challenge.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class getPersonIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String name;

    @BeforeEach
    void setUp() {

        name = "Sandra";
    }

    @Test
    void whenGetCelebrityIs() throws MalformedURLException {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/celebrity/findcelebrity/" + name).toString(), String.class
        );

        assertEquals("I'm here my name is: " + name + ", and I'm the celebrity", responseEntity.getBody());
    }

    @Test
    void whenGetCelebrityIsNot() throws MalformedURLException {
        String name = "Gustavo";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/celebrity/findcelebrity/" + name).toString(), String.class
        );

        assertEquals("This member: " + name + " is not the celebrity", responseEntity.getBody());
    }

    @Test
    void whenGetCelebrityNotExist() {
        String localName = "AnyMember";
        try{

            restTemplate.getForEntity(
                    new URL("http://localhost:" + port + "/celebrity/findcelebrity/" + localName).toString(), String.class
            );

        } catch (Exception e){
            assertTrue(e.getMessage().contains("This name: " + localName + " does not exist, please check the name team member and trying it again"));
        }
    }

    @Test
    void whenNameIsNull(){

        String localName = null;

        try{

            restTemplate.getForEntity(
                    new URL("http://localhost:" + port + "/celebrity/findcelebrity/" + null).toString(), String.class
            );

        } catch (Exception e){
            assertTrue(e.getMessage().contains("The name can not be null, please check out and trying again"));
        }
    }
}