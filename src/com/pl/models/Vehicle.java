package com.pl.models;

import com.pl.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
