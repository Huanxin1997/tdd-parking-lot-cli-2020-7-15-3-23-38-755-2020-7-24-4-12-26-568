package com.oocl.cultivation;

import com.oocl.cultivation.parkStratege.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    public static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    public static final String NOT_ENOUGH_POSITION = "Not enough position.";
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    private String message = "";
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Boolean validCarTicket(CarTicket ticket) {
        if (ticket == null) {
            message = PLEASE_PROVIDE_YOUR_PARKING_TICKET;
            return false;
        }
        return true;
    }

    public int getSpaceCount() {
        int remainingParkingSpaces = 0;
        for (ParkingLot parkingLot : this.parkingLots) {
            remainingParkingSpaces += parkingLot.getParkSpace();
        }
        if (remainingParkingSpaces < 1) {
            message = NOT_ENOUGH_POSITION;
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
        if(validCarTicket(ticket)) {
            Car car = null;
            if (this.message.equals("")) {
                for (ParkingLot parkingLot : parkingLots) {
                    if (parkingLot.fetchCar(ticket) != null) {
                        return parkingLot.fetchCar(ticket);
                    }
                }
            }
            message = UNRECOGNIZED_PARKING_TICKET;
        }
        return null;
    }
}
