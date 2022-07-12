package ru.imposya.firstcrudapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.imposya.firstcrudapp.models.Item;
import ru.imposya.firstcrudapp.models.Person;
import ru.imposya.firstcrudapp.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByItemName(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner) {
        return itemsRepository.findByOwner(owner);
    }

}
