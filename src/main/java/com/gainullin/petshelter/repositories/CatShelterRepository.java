package com.gainullin.petshelter.repositories;

import com.gainullin.petshelter.entities.CatShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatShelterRepository extends JpaRepository<CatShelter,Long> {
    @Query(value = "select information from catshelter",nativeQuery = true)
    String getInfo();

    @Query(value = "select address from catshelter", nativeQuery = true)
    String getAddress();

    @Query(value = "select working_hours from catshelter", nativeQuery = true)
    String getWorkingHours();
}
