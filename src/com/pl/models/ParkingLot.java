package com.pl.models;

import com.pl.enums.ParkingSlotType;
import com.pl.exceptions.SlotNotAvailableException;
import com.pl.utils.SlotUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> floors;
    private Map<ParkingSlotType, Map<Integer, ParkingSlotManager>> slotMapping;

    private static ParkingLot parkingLot;

    private ParkingLot(String name, Address address) {
        this.name = name;
        this.address = address;
        this.floors = new ArrayList<>();
        this.slotMapping = new HashMap<>();
    }

    public static ParkingLot getParkingLot(String name, Address address){
        if(parkingLot == null)
            parkingLot = new ParkingLot(name, address);
        return parkingLot;
    }

    public void addFloor(ParkingFloor floor){
        this.floors.add(floor);
    }

    public void removeFloor(ParkingFloor floor){
        this.floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        Map<Integer, ParkingSlotManager>   floorSlots = slotMapping.get(SlotUtil.getVehicleSlotType(vehicle.getVehicleType()));
        ParkingSlot parkingSlot = null;
        int floor = 0;
        for(Map.Entry<Integer, ParkingSlotManager> managerEntry : floorSlots.entrySet()){
            ParkingSlotManager slotManager = managerEntry.getValue();
            Optional<ParkingSlot> availableSLot = slotManager.getAvailableSlot();
            if(availableSLot.isPresent()) {
                parkingSlot = availableSLot.get();
                floor = managerEntry.getKey();
                break;
            }
        }
        if(parkingSlot == null)
            throw new SlotNotAvailableException("Slot not available for " + vehicle.getVehicleType());
        Ticket ticket = new Ticket();
        ticket.setFloor(floor);
        ticket.setInTime(new Date());
        parkingSlot.parkVehicle(vehicle);
        ticket.setParkingSlot(parkingSlot);
        //ticketManager.addTicket(ticket);
        return ticket;
    }

    public BigDecimal checkoutVehicle(Ticket ticket){
        BigDecimal parkingFare = null;
        try{
            Date inTime = ticket.getInTime();
            Date outTime = new Date();
            long diff = (outTime.getTime() - inTime.getTime());
            // calculating parking charge in sec
            long timeInHr = diff/(1000);
            parkingFare = new BigDecimal(timeInHr).multiply(ticket.getParkingSlot().getParkedVehicle().getVehicleType().getParkingCost());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(parkingFare != null)
            ticket.getParkingSlot().unParkVehicle();
        return parkingFare;
    }

    public void addParkingSlots(ParkingFloor parkingFloor, ParkingSlot slot){
        Map<Integer, ParkingSlotManager> slotManagerMap = slotMapping.getOrDefault(slot.getParkingSlotType(), new HashMap<>());

        ParkingSlotManager slotManager = slotManagerMap.getOrDefault(parkingFloor.getFloor(), new ParkingSlotManager());
        slotManager.addSlot(slot);
        slotManagerMap.put(parkingFloor.getFloor(), slotManager);

        slotMapping.put(slot.getParkingSlotType(), slotManagerMap);

        parkingFloor.setSlotManager(slotManager);
    }

}
