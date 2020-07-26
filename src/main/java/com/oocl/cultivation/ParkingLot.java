package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkSpace = 10;
    private String parkingLotId = "";
    private Map<CarTicket, Car> carTicketCarMap = new HashMap<>();

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

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public CarTicket parkCar(Car car) {
        if (!addCar()) return null;
        CarTicket ticket = new CarTicket(parkingLotId);
        carTicketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(CarTicket ticket) {
        Car fetchedCar = carTicketCarMap.get(ticket);
        if(fetchedCar != null) {
            removeCar(ticket);
        }
        return fetchedCar;
    }

    public Boolean validTicket(CarTicket expiredTicket) {
        return expiredTicket.getEffectiveness();
    }

    public Boolean addCar() {
        parkSpace--;
        return parkSpace >= 0;
    }

    public void removeCar(CarTicket ticket) {
        Car fetchedCar = carTicketCarMap.remove(ticket);
        parkSpace ++;
    }
}
