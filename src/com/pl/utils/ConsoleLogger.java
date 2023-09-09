package com.pl.utils;

public class ConsoleLogger implements Loggable{
    @Override
    public void log(Object obj) {
        System.out.println(obj);
        System.out.println(" ------------------------------------------------ ");
    }
}
