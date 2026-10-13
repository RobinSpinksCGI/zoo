package com.codecademy.zoo.controllers;

import com.codecademy.zoo.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    private final AnimalRepository animalRepository;

    public AnimalController(final AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
}
