package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class NormalParkingStratege implements ParkingStratege{
    @Override
    public CarTicket parkCar(Car car, List<ParkingLot> parkingLots) {
        CarTicket ticket = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkSpace() > 0) {
                ticket = parkingLot.parkCar(car);
                break;
            }
        }
        return ticket;
    }
}
