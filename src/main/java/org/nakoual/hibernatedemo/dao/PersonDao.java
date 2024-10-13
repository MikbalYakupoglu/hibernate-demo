package org.nakoual.hibernatedemo.dao;

import org.nakoual.hibernatedemo.entity.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PersonDao {

    List<Person> findAll() throws SQLException;

    Optional<Person> findById(int id) throws Exception;

    Person deleteById(int id) throws Exception;

    Person save(Person person) throws Exception;
}
