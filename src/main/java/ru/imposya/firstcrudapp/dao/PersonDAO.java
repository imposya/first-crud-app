package ru.imposya.firstcrudapp.dao;

import org.springframework.stereotype.Component;
import ru.imposya.firstcrudapp.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount,"Sasha"));
        people.add(new Person(++peopleCount,"Masha"));
        people.add(new Person(++peopleCount,"Vladik"));
        people.add(new Person(++peopleCount, "Antosha"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
