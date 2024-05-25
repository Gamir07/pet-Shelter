package com.gainullin.petshelter.repositories;

import com.gainullin.petshelter.entities.DogShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DogShelterRepository extends JpaRepository<DogShelter,Long> {

    @Query(value = "select information from dogshelter",nativeQuery = true)
    String getInfo();

    @Query(value = "select address from dogshelter", nativeQuery = true)
    String getAddress();
    @Query(value = "select working_hours from dogshelter", nativeQuery = true)
    String getWorkingHours();
}
