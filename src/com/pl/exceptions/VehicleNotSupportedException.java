package com.pl.exceptions;

public class VehicleNotSupportedException extends RuntimeException {
    public VehicleNotSupportedException(String format) {
        super(format);
    }
}
