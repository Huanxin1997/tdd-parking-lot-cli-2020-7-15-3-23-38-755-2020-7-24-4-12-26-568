package com.oocl.cultivation;

import com.oocl.cultivation.parkStratege.Parking;
import com.oocl.cultivation.parkStratege.ParkingStratege;
import com.oocl.cultivation.parkStratege.SmartParkingStratege;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket parkCar(Car car) {
        ParkingStratege parkingStratege = new SmartParkingStratege();
        Parking parking = new Parking(parkingStratege, parkingLots);
        return parking.parkCar(car);
    }

}
