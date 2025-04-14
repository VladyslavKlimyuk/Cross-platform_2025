package org.example.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private String name;
    private int experienceYears;
    private int drivingSkillLevel;
    private String requiredCargoType;
}