package ru.imposya.firstcrudapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.imposya.firstcrudapp.models.Person;


@Repository
public interface PeopleRepository extends JpaRepository <Person, Integer> {
} 
