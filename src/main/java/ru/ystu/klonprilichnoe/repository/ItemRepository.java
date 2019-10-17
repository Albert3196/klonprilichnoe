package ru.ystu.klonprilichnoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ystu.klonprilichnoe.domain.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);
}

