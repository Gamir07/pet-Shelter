package com.gainullin.petshelter.service.interfaces;

import com.gainullin.petshelter.entities.Cat;

import java.util.Optional;

public interface CatService {
    void save(Cat cat);

    Optional<Cat> findById(Long id);

    void remove(Cat cat);
}
