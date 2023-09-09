package com.pl.utils;

import com.pl.enums.ParkingSlotType;
import com.pl.enums.VehicleType;
import com.pl.exceptions.VehicleNotSupportedException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SlotUtil {
    public ParkingSlotType getVehicleSlotType(VehicleType vehicleType){
        ParkingSlotType parkingSlotType = null;
        switch (vehicleType){
            case BIKE -> {
                parkingSlotType = ParkingSlotType.TWO_WHEELER;
                break;
            }
            case CAR -> {
                parkingSlotType = ParkingSlotType.COMPACT;
                break;
            }

            case SUV -> {
                parkingSlotType = ParkingSlotType.SUV;
                break;
            }

            case BUS, TRUCK -> {
                parkingSlotType = ParkingSlotType.LARGE;
                break;
            }
            default -> throw new VehicleNotSupportedException(String.format("%s vehicleType can't be parked ", vehicleType));
        }
        return parkingSlotType;
    }
}
