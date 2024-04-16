package com.gainullin.petshelter.repositories;

import com.gainullin.petshelter.entities.PetReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetReportRepository extends JpaRepository<PetReport,Long> {
}
