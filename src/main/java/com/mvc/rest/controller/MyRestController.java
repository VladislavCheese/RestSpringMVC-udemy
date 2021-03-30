package com.mvc.rest.controller;

import com.mvc.rest.entity.PeopleEntity;
import com.mvc.rest.exception_handing.NoSuchPeopleException;
import com.mvc.rest.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }
    @GetMapping("/people")
    public List<PeopleEntity> showAllPeople(){
        return peopleService.getAllPeople();
    }
    @GetMapping("/people/{id}")
    public PeopleEntity getPerson(@PathVariable int id){
        PeopleEntity person = peopleService.getPerson(id);
        if(person == null) throw new NoSuchPeopleException("There is no person " +
                "with ID = " + id + " in Database");
        return person;
    }
    @PostMapping("/people")
    public PeopleEntity addNewPerson(@RequestBody PeopleEntity person){
        peopleService.savePerson(person);
        return person;
    }
    @PutMapping("/people")
    public PeopleEntity updatePerson(@RequestBody PeopleEntity person){
        peopleService.savePerson(person);
        return person;
    }
    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable int id){
        PeopleEntity person = peopleService.getPerson(id);
        if(person == null) throw new NoSuchPeopleException("There is no person " +
                "with ID = " + id + " in Database");
        peopleService.deletePerson(id);
        return "Person with ID = " + id + " was deleted";
    }
}
