package com.pl;

import com.pl.enums.ParkingSlotType;
import com.pl.enums.VehicleType;
import com.pl.models.Address;
import com.pl.models.ParkingFloor;
import com.pl.models.ParkingLot;
import com.pl.models.ParkingSlot;
import com.pl.models.Ticket;
import com.pl.models.Vehicle;
import com.pl.utils.ConsoleLogger;
import com.pl.utils.Loggable;

public class MainRunner {
    public static void main(String[] args) throws InterruptedException {
        Loggable logger = new ConsoleLogger();
        Address address = Address.builder()
                .address("12b HSR")
                .city("Bangalore")
                .build();

        ParkingLot parkingLot = ParkingLot.getParkingLot("Park+", address);
        ParkingFloor parkingFloor = new ParkingFloor(1);

        ParkingSlot parkingSlot = new ParkingSlot("t-1a", ParkingSlotType.TWO_WHEELER);
        ParkingSlot parkingSlot1 = new ParkingSlot("t-1b", ParkingSlotType.TWO_WHEELER);
        ParkingSlot parkingSlot2 = new ParkingSlot("t-1c", ParkingSlotType.TWO_WHEELER);
        logger.log("Adding two wheeler parking slot");
        parkingLot.addFloor(parkingFloor);
        parkingLot.addParkingSlots(parkingFloor, parkingSlot);
        parkingLot.addParkingSlots(parkingFloor, parkingSlot1);
        parkingLot.addParkingSlots(parkingFloor, parkingSlot2);

        logger.log("Added two wheeler parking  slot");

        logger.log("Adding car parking slot");
        ParkingSlot parkingSlot3 = new ParkingSlot("c-1a", ParkingSlotType.COMPACT);
        ParkingSlot parkingSlot4 = new ParkingSlot("c-1b", ParkingSlotType.COMPACT);

        parkingLot.addParkingSlots(parkingFloor, parkingSlot3);
        parkingLot.addParkingSlots(parkingFloor, parkingSlot4);
        logger.log("Added car parking slot");

        logger.log("Adding SUV parking slot");
        ParkingSlot parkingSlot5 = new ParkingSlot("s-1a", ParkingSlotType.SUV);
        ParkingSlot parkingSlot6 = new ParkingSlot("s-2b", ParkingSlotType.SUV);
        parkingLot.addParkingSlots(parkingFloor, parkingSlot5);
        parkingLot.addParkingSlots(parkingFloor, parkingSlot6);
        logger.log("Added SUV parking slot");

        Vehicle vehicle = new Vehicle("KA03KS1234", VehicleType.BIKE);
        Ticket vehicleTicket1 = parkingLot.parkVehicle(vehicle);
        logger.log("Parked " + vehicleTicket1);

        Vehicle car1 = new Vehicle("KL04AS0990", VehicleType.CAR);
        Ticket carTicket1 = parkingLot.parkVehicle(car1);
        logger.log("Parked " + carTicket1);

        Vehicle car2 = new Vehicle("TA046798", VehicleType.CAR);
        Ticket carTicket2 = parkingLot.parkVehicle(car2);
        logger.log("Parked " + carTicket2);

        Vehicle car3= new Vehicle("DL045689", VehicleType.CAR);
        Ticket carTicket3 = null;
        try{
            carTicket3 = parkingLot.parkVehicle(car3);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        logger.log("Parked " + carTicket3);

        Thread.sleep(10000);
//        BigDecimal parkingCharge = parkingLot.checkoutVehicle(carTicket1);
//        logger.log(String.format("Amount to be paid %s for ticket %s", parkingCharge, carTicket1));
        ParkingFloor parkingFloor2 = new ParkingFloor(2);
        parkingLot.addFloor(parkingFloor2);

        ParkingSlot carParkingSlot = new ParkingSlot("c-2a", ParkingSlotType.COMPACT);
        parkingLot.addParkingSlots(parkingFloor2, carParkingSlot);

        carTicket3 = parkingLot.parkVehicle(car3);
        logger.log("Parked " + carTicket3);
    }


}
