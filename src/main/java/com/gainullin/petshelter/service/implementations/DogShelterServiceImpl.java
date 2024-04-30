package com.gainullin.petshelter.service.implementations;

import com.gainullin.petshelter.repositories.DogShelterRepository;
import com.gainullin.petshelter.service.interfaces.DogShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogShelterServiceImpl implements DogShelterService {

    private final DogShelterRepository repository;

    /**
     * @return Метод возвращает общую информацию о приюте из базы данных
     */
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
