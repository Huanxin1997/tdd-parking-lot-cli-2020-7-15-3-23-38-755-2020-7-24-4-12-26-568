package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.List;

public interface ParkingStratege {
    CarTicket parkCar(Car car, List<ParkingLot> parkingLots);
}
