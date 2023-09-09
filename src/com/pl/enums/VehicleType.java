package com.pl.enums;

import java.math.BigDecimal;

public enum VehicleType {
    BIKE{
        @Override
        public BigDecimal getParkingCost() {
            return new BigDecimal(2);
        }
    },
    CAR{
        @Override
        public BigDecimal getParkingCost() {
            return new BigDecimal(5);
        }
    },
    SUV {
        @Override
        public BigDecimal getParkingCost() {
            return new BigDecimal(8);
        }
    },
    BUS{
        @Override
        public BigDecimal getParkingCost() {
            return new BigDecimal(20);
        }
    },
    TRUCK{
        @Override
        public BigDecimal getParkingCost() {
            return new BigDecimal(20);
        }
    };

    public abstract BigDecimal getParkingCost();
}
