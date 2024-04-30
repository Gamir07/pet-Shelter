package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean isHandicapped;
    private boolean isAdopted;
    private String filePathToPetPhoto;

    @ManyToOne
    @JoinColumn(name = "catshelter_id")
    private CatShelter shelter;
}
