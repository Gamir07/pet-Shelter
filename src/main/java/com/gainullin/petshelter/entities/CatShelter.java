package com.gainullin.petshelter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "catshelter")
public class CatShelter {
    @Id
    private Long id;
    private String information;
    private String address;
    private String workingHours;
    private String filePathToRoadMap;

    @OneToMany(mappedBy = "shelter")
    private List<Cat> catList;
}
