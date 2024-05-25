package com.gainullin.petshelter.service.implementations;

import com.gainullin.petshelter.entities.Owner;
import com.gainullin.petshelter.repositories.OwnerRepository;
import com.gainullin.petshelter.service.interfaces.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository repository;

    @Override
    public void save(Owner owner) {
        repository.save(owner);
    }

    /**
     * Поиск волонтера в базе данных
     * @return метод возвращает chat_id волонтера
     */
    @Override
    public String findVolunteer() {
        return repository.findVolunteer();
    }
}
