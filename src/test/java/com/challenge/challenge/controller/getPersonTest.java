package com.challenge.challenge.controller;

import com.challenge.challenge.service.ICelebrityService;
import com.challenge.challenge.service.impl.CelebrityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class getPersonTest {

    @Mock
    private ICelebrityService celebrityService;

    @InjectMocks
    private GetPerson getPerson = new GetPerson();

    @BeforeEach
    void setUp() {


    }

    @Test
    void whenGetNameIsNull() throws Exception {

        String localName ="";

        Exception exception = assertThrows(Exception.class, () -> getPerson.getCelebrity(localName));

        assertTrue(exception.getMessage().contains("The name can not be null, please check out and trying again"));
    }

    @Test
    void whenGetCelebrityNotExist(){
        String localName ="AnyMember";

        when(celebrityService.getCelebrity(localName)).thenReturn(Optional.empty());

        Exception result = assertThrows(Exception.class, () -> getPerson.getCelebrity(localName));

        assertTrue(result.getMessage().contains("This name: " + localName + " does not exist, please check the name team member and trying it again"));
    }

    @Test
    void whenGetCelebrityHasMember(){

        when(celebrityService.getCelebrity(anyString())).thenReturn(Optional.ofNullable("Susa"));

        assertTrue(celebrityService.getCelebrity(anyString()).isPresent());

    }
}