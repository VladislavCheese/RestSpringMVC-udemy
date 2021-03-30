package com.mvc.rest.service;

import com.mvc.rest.entity.PeopleEntity;

import java.util.List;

public interface PeopleService {
    List<PeopleEntity> getAllPeople();

    void savePerson(PeopleEntity person);

    PeopleEntity getPerson(int peopleId);

    void deletePerson(int personId);
}
