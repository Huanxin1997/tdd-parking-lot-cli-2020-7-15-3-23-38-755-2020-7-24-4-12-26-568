package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private String message;
    int level = 1;
    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots, int level) {
        this.parkingLots = parkingLots;
        this.level = level;
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
        if (level == 1) {
            ticket = selectParkinglotNormal(car);
        } else if (level == 2) {
            ticket = selectParkinglotSmart(car);
        } else {
            ticket = selectParkinglotSuperSmart(car);
        }
        return ticket;
    }

    public CarTicket selectParkinglotNormal(Car car) {
        CarTicket ticket = null;
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getParkSpace() > 0) {
                ticket = parkingLot.parkCar(car);
                break;
            }
        }
        return ticket;
    }

    public CarTicket selectParkinglotSmart(Car car) {
        CarTicket ticket = null;
        ParkingLot maxSpaceParkingLot = null;
        int maxSpace = 0;
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getParkSpace() > maxSpace) {
                maxSpace = parkingLot.getParkSpace();
                maxSpaceParkingLot = parkingLot;
            }
        }
        ticket = maxSpaceParkingLot.parkCar(car);
        return ticket;
    }

    public CarTicket selectParkinglotSuperSmart(Car car) {
        double largeAvailablePositionRate = 0.0;
        ParkingLot parkingLotWithLargerAvailablePosition = null;
        for (ParkingLot parkingLot : this.parkingLots) {
            int remainingParkingSpaces = parkingLot.getParkSpace();
            if (((double)remainingParkingSpaces / parkingLot.getCapacity()) > largeAvailablePositionRate) {
                largeAvailablePositionRate = remainingParkingSpaces / parkingLot.getCapacity();
                parkingLotWithLargerAvailablePosition = parkingLot;
            }
        }
        return parkingLotWithLargerAvailablePosition.parkCar(car);
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
        Car car = null;
        if (this.message == "") {
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
