package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkSpace = 10;
    private Map<CarTicket, Car> carTicketCarMap = new HashMap<>();

    public CarTicket parkCar(Car car) {
        if(!addCar()) return null;
        CarTicket ticket = new CarTicket();
        carTicketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(CarTicket ticket) {
        Car fetchedCar = carTicketCarMap.get(ticket);
        return fetchedCar;
    }

    public Boolean validTicket(CarTicket expiredTicket) {
        return expiredTicket.getEffectiveness();
    }

    public Boolean addCar() {
        parkSpace--;
        return parkSpace > 0;
    }
}
