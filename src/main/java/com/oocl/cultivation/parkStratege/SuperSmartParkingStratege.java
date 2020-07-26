package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class SuperSmartParkingStratege implements ParkingStratege {
    @Override
    public CarTicket park(Car car, List<ParkingLot> parkingLots) {
        double largeAvailablePositionRate = 0.0;
        ParkingLot parkingLotWithLargerAvailablePosition = null;
        for (ParkingLot parkingLot : parkingLots) {
            int remainingParkingSpaces = parkingLot.getParkSpace();
            if (((double)remainingParkingSpaces / parkingLot.getCapacity()) > largeAvailablePositionRate) {
                largeAvailablePositionRate = (double)remainingParkingSpaces / parkingLot.getCapacity();
                parkingLotWithLargerAvailablePosition = parkingLot;
            }
        }
        assert parkingLotWithLargerAvailablePosition != null;
        return parkingLotWithLargerAvailablePosition.parkCar(car);
    }
}
