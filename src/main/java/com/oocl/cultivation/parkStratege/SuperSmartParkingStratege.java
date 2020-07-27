package com.oocl.cultivation.parkStratege;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class SuperSmartParkingStratege implements ParkingStratege {
    @Override
    public CarTicket parkCar(Car car, List<ParkingLot> parkingLots) {
        double largeAvailablePositionRate = 0.0;
        ParkingLot parkingLotWithLargerAvailablePosition = null;
        parkingLotWithLargerAvailablePosition = getParkingLot(parkingLots, largeAvailablePositionRate, parkingLotWithLargerAvailablePosition);
        assert parkingLotWithLargerAvailablePosition != null;
        return parkingLotWithLargerAvailablePosition.parkCar(car);
    }

    private ParkingLot getParkingLot(List<ParkingLot> parkingLots, double largeAvailablePositionRate, ParkingLot parkingLotWithLargerAvailablePosition) {
        for (ParkingLot parkingLot : parkingLots) {
            int remainingParkingSpaces = parkingLot.getParkSpace();
            if (((double)remainingParkingSpaces / parkingLot.getCapacity()) > largeAvailablePositionRate) {
                largeAvailablePositionRate = (double)remainingParkingSpaces / parkingLot.getCapacity();
                parkingLotWithLargerAvailablePosition = parkingLot;
            }
        }
        return parkingLotWithLargerAvailablePosition;
    }
}
