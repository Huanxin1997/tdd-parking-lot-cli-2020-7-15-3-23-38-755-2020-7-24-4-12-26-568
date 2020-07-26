package com.oocl.cultivation;

import com.oocl.cultivation.parkStratege.NormalParkingStratege;
import com.oocl.cultivation.parkStratege.Parking;
import com.oocl.cultivation.parkStratege.ParkingStratege;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager {
    private List<ParkingBoy> parkingBoys;
    private final List<ParkingLot> parkingLots = new ArrayList<>();;

    public ParkingLotServiceManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public ParkingLotServiceManager() {
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Boolean addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
        parkingLots.addAll(parkingBoy.getParkingLots());
        return parkingBoys.get(parkingBoys.size() - 1) == parkingBoy;
    }

    public ParkingBoy specifyBoy(ParkingBoy expectedParkingBoy) {
        for(ParkingBoy parkingBoy : parkingBoys) {
            if(parkingBoy == expectedParkingBoy) {
                return expectedParkingBoy;
            }
        }
        return null;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public CarTicket parkCar(Car car) {
        ParkingStratege parkingStratege = new NormalParkingStratege();
        Parking parking = new Parking(parkingStratege, parkingLots);
        return parking.parkCar(car);
    }

    public Car fetchCar(CarTicket ticket) {
        for(ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetchCar(ticket);
            if(car != null) {
                return car;
            }
        }
        return null;
    }
}
