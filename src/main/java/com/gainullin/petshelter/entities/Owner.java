package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue
    private String chatId;
    private String name;
    private String phoneNumber;
    private boolean isVolunteer;
    private Date dateOfAdoption;
    private boolean hasCat;
    private boolean hasDog;

    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;


}
