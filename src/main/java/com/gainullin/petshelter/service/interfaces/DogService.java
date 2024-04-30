package com.gainullin.petshelter.service.interfaces;

import com.gainullin.petshelter.entities.Dog;

import java.util.Optional;

public interface DogService {
    void save(Dog dog);

    Optional<Dog> findById(Long id);

    void remove(Dog dog);
}
