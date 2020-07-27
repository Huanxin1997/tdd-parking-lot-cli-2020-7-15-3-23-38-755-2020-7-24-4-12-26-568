package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<ParkingLot> parkingLots;
    private final ParkingStratege parkingStratege;

    public Parking(ParkingStratege parkingStratege, List<ParkingLot> parkingLots) {
        this.parkingStratege = parkingStratege;
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public CarTicket parkCar(Car car) {
        return this.parkingStratege.parkCar(car, this.parkingLots);
    }

}
