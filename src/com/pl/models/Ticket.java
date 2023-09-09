package com.pl.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Ticket {
    private int floor;
    private ParkingSlot parkingSlot;
    private Date inTime;
}
