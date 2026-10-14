package com.codecademy.zoo.controllers;

import com.codecademy.zoo.entities.Animal;
import com.codecademy.zoo.repositories.AnimalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @GetMapping("/animals/{id}")
    public Animal getAnimalById(@PathVariable("id") Integer id) {
        Optional<Animal> animalOptional = this.animalRepository.findById(id);

        if (!animalOptional.isPresent()) {
            return null;
        }

        return animalOptional.get();
    }

    @PostMapping("/animals")
    public Animal createNewAnimal(@RequestBody Animal animal) {
        Animal newAnimal = this.animalRepository.save(animal);
        return newAnimal;
    }
}
