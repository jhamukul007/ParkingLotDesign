package com.pl.models;

import com.pl.enums.ParkingSlotType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParkingSlot {
    private String slot;
    private ParkingSlotType parkingSlotType;
    private Vehicle parkedVehicle;

    private boolean available;


    public ParkingSlot(String slot, ParkingSlotType parkingSlotType) {
        this.slot = slot;
        this.parkingSlotType = parkingSlotType;
        this.available = true;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.available = false;
    }

    public void unParkVehicle(){
        this.parkedVehicle = null;
        this.available = true;
    }
}


