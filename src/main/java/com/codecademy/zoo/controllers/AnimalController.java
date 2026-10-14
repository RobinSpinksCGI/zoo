package com.codecademy.zoo.controllers;

import com.codecademy.zoo.entities.Animal;
import com.codecademy.zoo.repositories.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        return animalOptional.orElse(null);
    }

    @GetMapping("/animals/search")
    public List<Animal> searchAnimals(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="minLegs", required = false) Integer minLegs,
            @RequestParam(name="flying", required = false) Boolean flying
    ) {
        if (name != null) {
            if (minLegs != null) {
                if (flying != null) {
                    if (flying) {
                        return this.animalRepository.findByNameAndNumLegsGreaterThanEqualAndCanFlyTrue(name, minLegs);
                    } else {
                        return this.animalRepository.findByNameAndNumLegsGreaterThanEqualAndCanFlyFalse(name, minLegs);
                    }
                }

                return this.animalRepository.findByNameAndNumLegsGreaterThanEqual(name, minLegs);
            }

            if (flying != null) {
                return flying ? this.animalRepository.findByNameAndCanFlyTrue(name) : this.animalRepository.findByNameAndCanFlyFalse(name);
            }

            return this.animalRepository.findByName(name);
        }

        if (minLegs != null) {
            if (flying != null) {
                if (flying) {
                    return this.animalRepository.findByNumLegsGreaterThanEqualAndCanFlyTrue(minLegs);
                } else {
                    return this.animalRepository.findByNumLegsGreaterThanEqualAndCanFlyFalse(minLegs);
                }
            }

            return this.animalRepository.findByNumLegsGreaterThanEqual(minLegs);
        }

        if (flying != null) {
            return flying ? this.animalRepository.findByCanFlyTrue() : this.animalRepository.findByCanFlyFalse();
        }

        return new ArrayList<>();
    }

    @PostMapping("/animals")
    public Animal createNewAnimal(@RequestBody Animal animal) {
        return this.animalRepository.save(animal);
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

    @DeleteMapping("animals/id")
    public Animal deleteAnimal(@PathVariable("id") Integer id) {
        Optional<Animal> animalToDeleteOptional = this.animalRepository.findById(id);
        if (animalToDeleteOptional.isEmpty()) return null;

        Animal animalToDelete = animalToDeleteOptional.get();
        this.animalRepository.delete(animalToDelete);
        return animalToDelete;
    }
}
