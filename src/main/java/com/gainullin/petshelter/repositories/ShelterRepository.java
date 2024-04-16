package com.gainullin.petshelter.repositories;

import com.gainullin.petshelter.entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter,Long> {
}
