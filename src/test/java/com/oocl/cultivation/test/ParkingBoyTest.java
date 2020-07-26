package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class ParkingBoyTest {
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = new CarTicket(false);

        //when
        parkingBoy.fetchCar(ticket);
        String result = parkingBoy.responseMessage();

        //then
        Assertions.assertEquals("Unrecognized parking ticket.", result);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        parkingBoy.fetchCar(null);
        String result = parkingBoy.responseMessage();

                //then
        Assertions.assertEquals("Please provide your parking ticket.", result);
    }

    @Test
    void should_return_not_enough_position_when_park_space_is_full_given_car() {
        // given
        ParkingLot parkingLot = new ParkingLot("0001");
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot), 1);

        // when
        for (int i = 0; i < 15; i++) {
            parkingBoy.parkCar(new Car());
        }
        String result = parkingBoy.responseMessage();

        // then
        Assertions.assertEquals("Not enough position.", result);
    }

    @Test
    void should_return_0002_when_parking_1_is_full_given_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot("0001");
        ParkingLot parkingLot2 = new ParkingLot("0002");
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 1);

        // when
        CarTicket ticket = null;
        for (int i = 0; i < 11; i++) {
            ticket = parkingBoy.parkCar(new Car());
        }

        // then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals("0002", ticket.getParkingLotId());
    }

    @Test
    void should_return_0001_when_parking_1_more_than_parking_2_given_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot("1");
        ParkingLot parkingLot2 = new ParkingLot("2");
        parkingLot1.setParkSpace(5);
        parkingLot2.setParkSpace(7);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 2);

        // when
        StringBuilder parkingPotSelectResults = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            parkingPotSelectResults.append(parkingBoy.parkCar(new Car()).getParkingLotId());
        }

        // then
        Assertions.assertEquals("22121", parkingPotSelectResults.toString());
    }

    @Test
    void should_return_0001_when_parking_1_larger_available_position_than_parking_2_given_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot("0001");
        ParkingLot parkingLot2 = new ParkingLot("0002");
        parkingLot1.setParkSpace(4);
        parkingLot2.setParkSpace(7);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 3);

        // when
        CarTicket ticket = null;
        for (int i = 0; i < 11; i++) {
            ticket = parkingBoy.parkCar(new Car());
        }

        // then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals("0001", ticket.getParkingLotId());
    }

    @Test
    void should_return_0002_when_parking1_7_capacity_parking2_3_capacity_given_8_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot("0001");
        ParkingLot parkingLot2 = new ParkingLot("0002");
        parkingLot1.setCapacity(7);
        parkingLot1.setCapacity(3);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 1);

        // when
        CarTicket ticket = null;
        for (int i = 0; i < 8; i++) {
            ticket = parkingBoy.parkCar(new Car());
        }

        // then
        Assertions.assertEquals("0002", ticket.getParkingLotId());
    }

}
