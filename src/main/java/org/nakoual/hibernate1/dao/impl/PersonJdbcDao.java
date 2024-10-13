package org.nakoual.hibernate1.dao.impl;

import org.nakoual.hibernate1.dao.PersonDao;
import org.nakoual.hibernate1.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonJdbcDao implements PersonDao {

    private final DataSource datasource;

    @Autowired
    public PersonJdbcDao(DataSource datasource) {
        this.datasource = datasource;
    }

    public List<Person> findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = datasource.getConnection();
            preparedStatement = connection.prepareStatement("select * from persons");
            resultSet = preparedStatement.executeQuery();

            List<Person> personList = new ArrayList<>();
            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setLocation(resultSet.getString("location"));
                person.setBirthDate(resultSet.getDate("birth_date"));

                personList.add(person);
            }

            return personList;

        } finally {
            closeConnections(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public Optional<Person> findById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = datasource.getConnection();
            preparedStatement = connection.prepareStatement("select * from persons where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            Person person = new Person();
            while(resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setLocation(resultSet.getString("location"));
                person.setBirthDate(resultSet.getDate("birth_date"));
            }

            return person.getId() == null ? Optional.empty() : Optional.of(person);
        } finally {
            closeConnections(connection, preparedStatement, resultSet);
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

    private void closeConnections(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(connection != null){
            connection.close();
        }
        if(preparedStatement != null){
            preparedStatement.close();
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
}
