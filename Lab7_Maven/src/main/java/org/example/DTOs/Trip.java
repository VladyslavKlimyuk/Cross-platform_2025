package org.example.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    private RouteRequest request;
    private Driver driver;
    private Car car;
    private boolean isCompleted;
    private boolean isCarBrokenDuringTrip;
    private double payment;
}