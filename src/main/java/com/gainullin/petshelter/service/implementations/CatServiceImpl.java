package com.gainullin.petshelter.service.implementations;

import com.gainullin.petshelter.entities.Cat;
import com.gainullin.petshelter.repositories.CatRepository;
import com.gainullin.petshelter.service.interfaces.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository repository;

    @Override
    public void save(Cat cat) {
        repository.save(cat);
    }

    @Override
    public Optional<Cat> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Cat cat) {
        repository.delete(cat);
    }
}
