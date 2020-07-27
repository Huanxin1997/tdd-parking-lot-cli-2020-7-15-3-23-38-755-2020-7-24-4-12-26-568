package com.oocl.cultivation;

import com.oocl.cultivation.parkStratege.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private String message;
    int level = 1;
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots, int level) {
        this.parkingLots = parkingLots;
        this.level = level;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void receiveTicketFromCustomer(CarTicket ticket) {
        if (ticket == null) {
            message = "Please provide your parking ticket.";
        } else if (!ticket.getEffectiveness()) {
            message = "Unrecognized parking ticket.";
        } else {
            message = "";
        }
    }

    public int checkSpaceCount() {
        int remainingParkingSpaces = 0;
        for (ParkingLot parkingLot : this.parkingLots) {
            remainingParkingSpaces += parkingLot.getParkSpace();
        }
        if (remainingParkingSpaces < 1) {
            message = "Not enough position.";
        }
        return remainingParkingSpaces;
    }

    public CarTicket selectParkinglot(Car car) {
        CarTicket ticket;
        ParkingStratege parkingStratege = new NormalParkingStratege();
        Parking parking = new Parking(parkingStratege, parkingLots);
        ticket = parking.parkCar(car);
        return ticket;
    }

    public String responseMessage() {
        return message;
    }

    public CarTicket parkCar(Car car) {
        if (getSpaceCount() < 1) {
            return null;
        } else {
            return selectParkinglot(car);
        }
    }

    public Car fetchCar(CarTicket ticket) {
        receiveTicketFromCustomer(ticket);
        Car car = null;
        if (this.message.equals("")) {
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.fetchCar(ticket) != null) {
                    car = parkingLot.fetchCar(ticket);
                    break;
                }
            }
        }
        return car;
    }
}
