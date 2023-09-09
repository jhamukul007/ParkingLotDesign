package com.pl.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor {
    private Integer floor;
    private ParkingSlotManager slotManager;

    public ParkingFloor(Integer floor) {
        this.floor = floor;
        this.slotManager = new ParkingSlotManager();
    }

    public void addSlot(ParkingSlot slot){
        this.slotManager.addSlot(slot);
    }

    public void removeSlot(ParkingSlot slot){
        this.slotManager.removeSlot(slot);
    }

}
