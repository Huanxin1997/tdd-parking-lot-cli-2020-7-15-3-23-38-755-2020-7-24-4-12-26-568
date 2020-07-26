package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class SmartParkingStratege implements ParkingStratege{
    @Override
    public CarTicket park(Car car, List<ParkingLot> parkingLots) {
        CarTicket ticket = null;
        ParkingLot maxSpaceParkingLot = null;
        int maxSpace = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkSpace() > maxSpace) {
                maxSpace = parkingLot.getParkSpace();
                maxSpaceParkingLot = parkingLot;
            }
        }
        ticket = maxSpaceParkingLot.parkCar(car);
        return ticket;
    }
}
