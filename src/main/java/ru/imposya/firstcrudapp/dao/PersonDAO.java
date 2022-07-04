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

        people.add(new Person(++peopleCount,"Sasha", 24, "awd@mail.ru"));
        people.add(new Person(++peopleCount,"Masha", 24,"awda1@gmail.com"));
        people.add(new Person(++peopleCount,"Vladik", 28, "awlavla@ref.com"));
        people.add(new Person(++peopleCount, "Antosha", 24, "wadijwoias@list.ru"));
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
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        personToBeUpdated.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
