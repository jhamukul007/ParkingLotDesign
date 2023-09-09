package com.pl.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class ParkingSlotManager {
    private List<ParkingSlot> slots;

    public ParkingSlotManager() {
        this.slots = new ArrayList<>();
    }

    public void addSlot(ParkingSlot slot){
        this.slots.add(slot);
    }

    public void removeSlot(ParkingSlot slot){
        this.slots.remove(slot);
    }

    public Optional<ParkingSlot> getAvailableSlot(){
        return slots.stream().filter(ParkingSlot::isAvailable).findAny();
    }

}
