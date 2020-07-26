package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class Parking {
    private final List<ParkingLot> parkingLots;
    private final ParkingStratege parkingStratege;

    public Parking(ParkingStratege parkingStratege, List<ParkingLot> parkingLots) {
        this.parkingStratege = parkingStratege;
        this.parkingLots = parkingLots;
    }

    public CarTicket parkCar(Car car) {
        return this.parkingStratege.park(car, parkingLots);
    }

}
