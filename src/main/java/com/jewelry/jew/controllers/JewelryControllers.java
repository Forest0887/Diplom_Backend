package com.jewelry.jew.controllers;

import com.jewelry.jew.entity.Jewelry;
import com.jewelry.jew.repository.JewelryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class JewelryControllers {

    private final JewelryRepository jewelryRepository;

    public JewelryControllers(JewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @GetMapping("/jewelry/all")
    public List<Jewelry> getAllJewelry() {
        return (List<Jewelry>) jewelryRepository.findAll();
    }

    @PostMapping("/jewelry")
    void addJewelry(@RequestParam String name) {
        jewelryRepository.save(new Jewelry(name));
    }

    //  сделать, чтоб на фронте сохранялся id изделия и после отправлялся на бек при удалении
    @PostMapping("/jewelry/{id}/remove")
    void removeJewelryById(@PathVariable(value = "id") long id) {
        jewelryRepository.deleteById(id);
    }

    @PostMapping("/jewelry/{id}/update")
    void updateJewelry(@PathVariable(value = "id") long id, @RequestParam String name) {
        Optional<Jewelry> jewelryOpt = jewelryRepository.findById(id);
        if (jewelryOpt.isPresent()){
            final Jewelry jewelry = jewelryOpt.get();
            jewelryRepository.save(new Jewelry(jewelry.getId(), name));
        }
    }
}