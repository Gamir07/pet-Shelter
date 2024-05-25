package com.gainullin.petshelter.service.implementations;

import com.gainullin.petshelter.entities.PetReport;
import com.gainullin.petshelter.repositories.PetReportRepository;
import com.gainullin.petshelter.service.interfaces.PetReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetReportServiceImpl implements PetReportService {

    private final PetReportRepository repository;

    @Override
    public void saveReport(PetReport petReport) {
        repository.save(petReport);
    }
}
