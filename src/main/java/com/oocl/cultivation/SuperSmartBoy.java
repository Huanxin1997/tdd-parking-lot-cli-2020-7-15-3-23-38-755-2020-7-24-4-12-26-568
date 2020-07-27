package com.oocl.cultivation;

import com.oocl.cultivation.parkStratege.Parking;
import com.oocl.cultivation.parkStratege.ParkingStratege;
import com.oocl.cultivation.parkStratege.SuperSmartParkingStratege;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartBoy extends ParkingBoy{
    private List<ParkingLot> parkingLots;

    public SuperSmartBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public CarTicket parkCar(Car car) {
        ParkingStratege parkingStratege = new SuperSmartParkingStratege();
        Parking parking = new Parking(parkingStratege, parkingLots);
        return parking.parkCar(car);
    }
}
