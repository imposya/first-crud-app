package ru.imposya.firstcrudapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.imposya.firstcrudapp.models.Item;
import ru.imposya.firstcrudapp.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String itemName);
    List<Item> findByOwner(Person person);
}
