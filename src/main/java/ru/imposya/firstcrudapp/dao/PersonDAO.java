package ru.imposya.firstcrudapp.dao;

import org.springframework.stereotype.Component;
import ru.imposya.firstcrudapp.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    //public Person show(int id) {
    //    return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    //}

    public void save(Person person) {
        try {
            Statement stmt = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //public void update(int id, Person updatedPerson) {
    //    Person personToBeUpdated = show(id);
    //    personToBeUpdated.setName(updatedPerson.getName());
    //    personToBeUpdated.setEmail(updatedPerson.getEmail());
    //    personToBeUpdated.setAge(updatedPerson.getAge());
    //}

    //public void delete(int id) {
   //     people.removeIf(person -> person.getId() == id);
    //}
}
