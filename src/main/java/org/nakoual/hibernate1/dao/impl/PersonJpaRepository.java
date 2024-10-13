package org.nakoual.hibernate1.dao.impl;

import org.nakoual.hibernate1.dao.PersonDao;
import org.nakoual.hibernate1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends PersonDao, JpaRepository<Person, Integer> {

}
