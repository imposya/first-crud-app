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
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person show(int id) {
        Person person = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Person WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setEmail(resultSet.getString(4));
            person.setAge(resultSet.getInt(3));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public void save(Person person) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Person VALUES (1, ?, ?, ?)");
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getAge());
            pstmt.setString(3, person.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Person SET name=?, age=?, " +
                    "email=? WHERE id =?");
            pstmt.setString(1, updatedPerson.getName());
            pstmt.setInt(2, updatedPerson.getAge());
            pstmt.setString(3, updatedPerson.getEmail());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Person WHERE id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
