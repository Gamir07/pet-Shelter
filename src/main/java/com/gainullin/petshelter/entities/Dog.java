package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean isHandicapped;
    private boolean isAdopted;
    private String filePathToPetPhoto;

    @ManyToOne
    @JoinColumn(name = "dogshelter_id")
    private DogShelter shelter;
}
