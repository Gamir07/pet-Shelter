package com.gainullin.petshelter.service.implementations;

import com.gainullin.petshelter.entities.Dog;
import com.gainullin.petshelter.repositories.DogRepository;
import com.gainullin.petshelter.service.interfaces.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository repository;

    @Override
    public void save(Dog dog) {
        repository.save(dog);
    }

    @Override
    public Optional<Dog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Dog dog) {
        repository.delete(dog);
    }
}
