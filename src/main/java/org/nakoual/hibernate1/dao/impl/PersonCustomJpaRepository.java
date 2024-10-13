package org.nakoual.hibernate1.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.nakoual.hibernate1.dao.PersonDao;
import org.nakoual.hibernate1.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PersonCustomJpaRepository implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    @Override
    public Optional<Person> findById(int id) {
        Person person = null;
        try {
            person = entityManager.find(Person.class, id);
            return Optional.of(person);
        } catch (EntityNotFoundException e) {
            return Optional.empty();
        }
    }

    @Override
    public Person deleteById(int id) {
        return null; //remove
    }

    @Override
    public Person save(Person person) {
        return null; //merge
    }
}
