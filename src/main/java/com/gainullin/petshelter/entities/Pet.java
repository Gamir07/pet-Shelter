package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "pet")
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean isHandicapped;
    private boolean isAdopted;
    @Lob
    private byte[] petPhoto;
    @ManyToOne
    private Shelter shelter;

}
