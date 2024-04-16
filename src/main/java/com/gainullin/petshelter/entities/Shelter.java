package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "shelter")
public abstract class Shelter {
    @Id
    @GeneratedValue
    private long id;
    private String information;
    private String address;
    @Lob
    private byte[] roadMap;

    @OneToMany(mappedBy = "shelter")
    private List<Pet> petList;

}
