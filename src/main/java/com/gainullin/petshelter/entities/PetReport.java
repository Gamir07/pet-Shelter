package com.gainullin.petshelter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class PetReport {
    @Id
    @GeneratedValue
    private long id;
    @Lob
    private byte[] dailyPhotoReport;
    private String diet;
    private String wellbeing;
    private String habits;
    private String filePath;
    private String mediaType;
    private String fileSize;
    private Date dateOfReport;
    private boolean isChecked;

    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;
}
