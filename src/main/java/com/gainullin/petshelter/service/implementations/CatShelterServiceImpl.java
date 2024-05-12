package com.gainullin.petshelter.service.implementations;

import com.gainullin.petshelter.repositories.CatShelterRepository;
import com.gainullin.petshelter.service.interfaces.CatShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CatShelterServiceImpl implements CatShelterService {
    private final CatShelterRepository repository;

    @Override
    public String getInfo() {
        return repository.getInfo();
    }

    @Override
    public String getAddress() {
        return repository.getAddress();
    }

    @Override
    public String getWorkingHours() {
        return repository.getWorkingHours();
    }
}
