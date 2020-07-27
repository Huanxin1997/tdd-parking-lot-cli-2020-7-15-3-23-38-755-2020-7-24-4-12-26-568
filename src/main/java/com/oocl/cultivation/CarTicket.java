package com.oocl.cultivation;

public class CarTicket {
    private ParkingLot parkingLot;

    public CarTicket() {
    }

    public CarTicket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }
}
