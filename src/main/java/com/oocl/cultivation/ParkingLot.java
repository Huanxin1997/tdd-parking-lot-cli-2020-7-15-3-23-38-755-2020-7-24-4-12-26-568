package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> carTicketCarMap = new HashMap<>();

    public CarTicket parkCar(Car car) {
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
}
