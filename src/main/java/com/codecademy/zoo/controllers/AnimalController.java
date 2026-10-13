package com.codecademy.zoo.controllers;

import com.codecademy.zoo.entities.Animal;
import com.codecademy.zoo.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    private final AnimalRepository animalRepository;

    public AnimalController(final AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAllAnimals() {
        return this.animalRepository.findAll();
    }
}
