package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkSpace = 10;
    private int capacity = 10;
    private String parkingLotId = "";
    private final Map<CarTicket, Car> carTicketCarMap = new HashMap<>();

    public ParkingLot(String parkingPotId) {
        this.parkingLotId = parkingPotId;
    }

    public ParkingLot() {
    }

    public int getParkSpace() {
        return parkSpace;
    }

    public void setParkSpace(int parkSpace) {
        this.parkSpace = parkSpace;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        this.parkSpace = capacity;
    }

    public CarTicket parkCar(Car car) {
        if (!addCar()) return null;
        CarTicket ticket = new CarTicket(parkingLotId);
        carTicketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(CarTicket ticket) {
        Car fetchedCar = carTicketCarMap.get(ticket);
        if (fetchedCar != null) {
            removeCar(ticket);
        }
        return fetchedCar;
    }

    public Boolean addCar() {
        if(parkSpace == 0) {
            return false;
        }
        parkSpace--;
        return true;
    }

    public void removeCar(CarTicket ticket) {
        carTicketCarMap.remove(ticket);
        parkSpace++;
    }
}
