package com.gainullin.petshelter.repositories;

import com.gainullin.petshelter.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,String> {
}
