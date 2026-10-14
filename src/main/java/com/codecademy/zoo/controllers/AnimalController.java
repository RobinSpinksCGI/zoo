package com.codecademy.zoo.controllers;

import com.codecademy.zoo.entities.Animal;
import com.codecademy.zoo.repositories.AnimalRepository;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/animals/{id}")
    public Animal updateAnimal(@PathVariable("id") Integer id, @RequestBody Animal animal) {
        Optional<Animal> animalToUpdateOptional = this.animalRepository.findById(id);
        if (animalToUpdateOptional.isEmpty()) return null;

        Animal animalToUpdate = animalToUpdateOptional.get();

        if (animal.getName() != null) animalToUpdate.setName(animal.getName());
        if (animal.getCanFly() != null) animalToUpdate.setCanFly(animal.getCanFly());
        if (animal.getHasWings() != null) animalToUpdate.setHasWings(animal.getHasWings());
        if (animal.getNumLegs() != null) animalToUpdate.setNumLegs(animal.getNumLegs());

        return this.animalRepository.save(animalToUpdate);
    }
}
