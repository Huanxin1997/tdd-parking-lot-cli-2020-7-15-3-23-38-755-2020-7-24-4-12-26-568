package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = new CarTicket(false);
        Car car = new Car();

        //when
        String result = parkingBoy.receiveTicketFromCustomer(ticket);

        //then
        Assertions.assertEquals("Unrecognized parking ticket.", result);
    }
}
