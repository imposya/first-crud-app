package ru.imposya.firstcrudapp.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.imposya.firstcrudapp.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt(1));
        person.setName(resultSet.getString(2));
        person.setAge(resultSet.getInt(3));
        person.setEmail(resultSet.getString(4));
        return person;
    }
}
