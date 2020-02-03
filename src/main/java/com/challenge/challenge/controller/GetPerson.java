package com.challenge.challenge.controller;

import com.challenge.challenge.service.ICelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/celebrity")
public class GetPerson {

    @Autowired
    ICelebrityService iCelebrityService;

    @GetMapping(value = "findcelebrity/{name}")
    public String getCelebrity(@PathVariable ("name") String name) throws Exception {

        if(name.isEmpty() || name == null){
            throw new Exception("The name can not be null, please check out and trying again");
        }

        Optional<String> celebrity = iCelebrityService.getCelebrity(name);

        if(!celebrity.isPresent()){
            throw new Exception("This name: " + name + " does not exist, please check the name team member and trying it again");
        }

        return  celebrity.get();
    }
}
