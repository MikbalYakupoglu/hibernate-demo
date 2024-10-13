package org.nakoual.hibernate1.dao.impl;

import org.nakoual.hibernate1.dao.PersonDao;
import org.nakoual.hibernate1.entity.Person;
import org.nakoual.hibernate1.mapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonSpringJdbcDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonSpringJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM persons", new PersonRowMapper());
    }

    @Override
    public Optional<Person> findById(int id) throws Exception {
        Person person = null;
        try {
            person = jdbcTemplate.queryForObject("SELECT * FROM persons where id = ?"
                    , new PersonRowMapper(), id);
            return Optional.ofNullable(person);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Person deleteById(int id) throws Exception {
        return null;
    }

    @Override
    public Person save(Person person) throws Exception {
        return null;
    }
}
