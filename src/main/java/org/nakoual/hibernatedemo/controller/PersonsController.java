package org.nakoual.hibernatedemo.controller;

import org.nakoual.hibernatedemo.dao.PersonDao;
import org.nakoual.hibernatedemo.dto.result.SuccessResult;
import org.nakoual.hibernatedemo.entity.Person;
import org.nakoual.hibernatedemo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private final PersonDao personDao;

    @Autowired
    public PersonsController(@Qualifier("personSpringJdbcDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public SuccessResult<List<Person>> getAllPersons() throws Exception {
        return new SuccessResult<>(personDao.findAll());
    }

    @GetMapping("/{id}")
    public SuccessResult<Person> getPersonById(@PathVariable int id) throws Exception {
        return new SuccessResult<>(personDao.findById(id).orElseThrow(() -> new NotFoundException(String.format("Person with id %s not found", id))));


    }
}
