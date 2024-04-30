package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dogshelter")
public class DogShelter {
    @Id
    @GeneratedValue
    private long id;
    private String information;
    private String address;
    private String workingHours;
    private String filePathToRoadMap;

    @OneToMany(mappedBy = "shelter")
    private List<Dog> dogList;

}
