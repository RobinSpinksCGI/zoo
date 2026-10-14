package com.codecademy.zoo.repositories;

import com.codecademy.zoo.entities.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    List<Animal> findByName(String name);
    List<Animal> findByNumLegsGreaterThanEqual(Integer minLegs);
    List<Animal> findByCanFlyTrue();
    List<Animal> findByCanFlyFalse();
    List<Animal> findByNameAndNumLegsGreaterThanEqual(String name, Integer minLegs);
    List<Animal> findByNameAndCanFlyTrue(String name);
    List<Animal> findByNameAndCanFlyFalse(String name);
    List<Animal> findByNumLegsGreaterThanEqualAndCanFlyTrue(Integer minLegs);
    List<Animal> findByNumLegsGreaterThanEqualAndCanFlyFalse(Integer minLegs);
    List<Animal> findByNameAndNumLegsGreaterThanEqualAndCanFlyTrue(String name, Integer minLegs);
    List<Animal> findByNameAndNumLegsGreaterThanEqualAndCanFlyFalse(String name, Integer minLegs);
}