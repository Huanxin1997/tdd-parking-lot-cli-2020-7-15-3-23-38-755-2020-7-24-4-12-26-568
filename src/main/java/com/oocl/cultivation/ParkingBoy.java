package com.oocl.cultivation;

public class ParkingBoy {
    private String message;
    ParkingLot parkingLot = new ParkingLot();

    public void receiveTicketFromCustomer(CarTicket ticket) {
        if (ticket == null) {
            message = "Please provide your parking ticket.";
        }

        message =  "Unrecognized parking ticket.";
    }

    public int checkSpaceCount() {
        int spaceCount = parkingLot.getParkSpace();
        if(spaceCount < 1) {
            message = "Not enough position.";
        }
        return spaceCount;
    }

    public String responseMessage() {
        return message;
    }

    public CarTicket parkCar(Car car) {
        if(checkSpaceCount() < 0) {
            return null;
        } else {
            CarTicket ticket = parkingLot.parkCar(car);
            return ticket;
        }
    }
}
