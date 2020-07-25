package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private String message;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingBoy() {
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
        CarTicket ticket = null;
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getParkSpace() > 0) {
                ticket = parkingLot.parkCar(car);
                break;
            }
        }
        return ticket;
    }

    public String responseMessage() {
        return message;
    }

    public CarTicket parkCar(Car car) {
        if (checkSpaceCount() < 1) {
            return null;
        } else {
            return selectParkinglot(car);
        }
    }

    public Car fetchCar(CarTicket ticket) {
        receiveTicketFromCustomer(ticket);
        if(this.message == "") {
            for(ParkingLot parkingLot : parkingLots) {
                if(parkingLot.fetchCar(ticket) != null) {
                    return parkingLot.fetchCar(ticket);
                }
            }
        }
        return null;
    }
}
