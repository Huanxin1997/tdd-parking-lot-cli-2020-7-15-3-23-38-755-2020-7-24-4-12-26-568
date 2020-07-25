package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
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
        parkingBoy.receiveTicketFromCustomer(ticket);
        String result = parkingBoy.responseMessage();

        //then
        Assertions.assertEquals("Unrecognized parking ticket.", result);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        parkingBoy.receiveTicketFromCustomer(null);
        String result = parkingBoy.responseMessage();

                //then
        Assertions.assertEquals("Please provide your parking ticket.", result);
    }

    @Test
    void should_return_not_enough_position_when_park_space_is_full_given_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy();

        // when
        for (int i = 0; i <= 18; i++) {
            parkingBoy.parkCar(new Car());
        }
        String result = parkingBoy.responseMessage();
        // then
        Assertions.assertEquals("Not enough position.", result);
    }
}
