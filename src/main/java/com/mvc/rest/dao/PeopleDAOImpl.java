package com.mvc.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.mvc.rest.entity.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleDAOImpl implements PeopleDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PeopleEntity> getAllPeople() {
        Session session = sessionFactory.getCurrentSession();

//        List<PeopleEntity> result = session.createQuery("FROM PeopleEntity",PeopleEntity.class).getResultList();

        Query<PeopleEntity> query = session.createQuery("FROM PeopleEntity",PeopleEntity.class);
        List<PeopleEntity> result = query.getResultList();

        return result;
    }

    @Override
    public void savePerson(PeopleEntity person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
    }

    @Override
    public PeopleEntity getPerson(int peopleId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PeopleEntity.class, peopleId);
    }

    @Override
    public void deletePerson(int personId) {
        Session session = sessionFactory.getCurrentSession();
        Query<PeopleEntity> query = session.createQuery("DELETE FROM PeopleEntity WHERE peopleId "
        + "= : currentPerson");
        query.setParameter("currentPerson", personId);
        query.executeUpdate();
    }
}
