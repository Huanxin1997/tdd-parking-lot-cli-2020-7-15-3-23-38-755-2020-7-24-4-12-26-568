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

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String result = parkingBoy.receiveTicketFromCustomer(null);

        //then
        Assertions.assertEquals("Please provide your parking ticket.", result);
    }
}
