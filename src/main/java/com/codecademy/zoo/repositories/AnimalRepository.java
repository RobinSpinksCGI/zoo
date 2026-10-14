package com.codecademy.zoo.repositories;

import com.codecademy.zoo.entities.Animal;
import org.springframework.data.jpa.repository.Query;
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
//    List<Animal> findByNameAndNumLegsGreaterThanEqualAndCanFlyTrue(String name, Integer minLegs);
//    List<Animal> findByNameAndNumLegsGreaterThanEqualAndCanFlyFalse(String name, Integer minLegs);
    @Query(value = "SELECT a FROM Animal a WHERE name = ?1 AND numLegs >= ?2 AND canFly = ?3", nativeQuery = true)
    List<Animal> findByFullSearch(String name, Integer minLegs, Boolean flying);
}