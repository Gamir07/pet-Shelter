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
    private long chatId;
    private String name;
    private String phoneNumber;
    private boolean isVolunteer;
    private Date dateOfAdoption;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


}
