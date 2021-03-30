package com.mvc.rest.dao;

import com.mvc.rest.entity.PeopleEntity;

import java.util.List;

public interface PeopleDAO {
    List<PeopleEntity> getAllPeople();

    void savePerson(PeopleEntity person);

    PeopleEntity getPerson(int peopleId);

    void deletePerson(int personId);
}
