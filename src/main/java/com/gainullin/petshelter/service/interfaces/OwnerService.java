package com.gainullin.petshelter.service.interfaces;


import com.gainullin.petshelter.entities.Owner;

public interface OwnerService {
    void save(Owner owner);
    String findVolunteer();
}
