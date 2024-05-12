package com.gainullin.petshelter.repositories;

import com.gainullin.petshelter.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {

    @Query(value = "select chat_id from owner where is_volunteer = true", nativeQuery = true)
    String findVolunteer();
}
