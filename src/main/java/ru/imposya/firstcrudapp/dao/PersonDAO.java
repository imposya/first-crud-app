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

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
