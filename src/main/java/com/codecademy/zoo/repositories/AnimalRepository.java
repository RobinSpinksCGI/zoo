package com.codecademy.zoo.repositories;

import com.codecademy.zoo.entities.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {

}