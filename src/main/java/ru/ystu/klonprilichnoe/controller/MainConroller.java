package ru.ystu.klonprilichnoe.controller;

import com.sun.media.jfxmedia.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ystu.klonprilichnoe.domain.Item;
import ru.ystu.klonprilichnoe.repository.ItemRepository;

import java.awt.*;
import java.util.Optional;

@RestController("/api")
public class MainConroller {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(value = "")
    public Iterable<Item> getAll() { return itemRepository.findAll(); }
    @GetMapping(value = "/id/{id}")
    public Item getById(@PathVariable Long id){
        Item item = new Item();
        return itemRepository.findById(id).orElse(item);
    }
    @GetMapping(value = "/name/{name}")
    public Iterable<Item> getById(@PathVariable String name) { return itemRepository.findByName(name); }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item setItem(@RequestBody Item item) { return itemRepository.save(item); }

    @PostMapping(value = "{id}")
    public Optional<Item> updateItem(@PathVariable Long id, @RequestBody Item item){
        item.setId(id);
        itemRepository.save(item);
        return itemRepository.findById(id);
    }

    @PostMapping(value = "/delete/{id}")
    public Iterable<Item> rmItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        return itemRepository.findAll();
    }
}
