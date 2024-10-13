package org.nakoual.hibernatedemo.dao.impl;

import org.nakoual.hibernatedemo.dao.PersonDao;
import org.nakoual.hibernatedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends PersonDao, JpaRepository<Person, Integer> {

}
