package com.oocl.cultivation.test;

import com.oocl.cultivation.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ParkingBoyTest {
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = new CarTicket();

        //when
        parkingBoy.fetchCar(ticket);
        String result = parkingBoy.responseMessage();

        //then
        assertEquals("Unrecognized parking ticket.", result);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        parkingBoy.fetchCar(null);
        String result = parkingBoy.responseMessage();

                //then
        assertEquals("Please provide your parking ticket.", result);
    }

    @Test
    void should_return_not_enough_position_when_park_space_is_full_given_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));

        // when
        for (int i = 0; i < 15; i++) {
            parkingBoy.parkCar(new Car());
        }
        String result = parkingBoy.responseMessage();

        // then
        assertEquals("Not enough position.", result);
    }

    @Test
    void should_return_0002_when_parking_1_is_full_given_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        // when
        CarTicket ticket = null;
        for (int i = 0; i < 11; i++) {
            ticket = parkingBoy.parkCar(new Car());
        }

        // then
        assertNotNull(ticket);
        assertEquals(parkingLot2, ticket.getParkingLot());
    }

    @Test
    void should_return_0001_when_parking_1_more_than_parking_2_given_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot1.setParkSpace(5);
        parkingLot2.setParkSpace(7);
        ParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        // when
        ArrayList<ParkingLot> parkingPotSelectResults = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            parkingPotSelectResults.add(parkingBoy.parkCar(new Car()).getParkingLot());
        }

        // then
        assertEquals(parkingLot2, parkingPotSelectResults.get(0));
        assertEquals(parkingLot2, parkingPotSelectResults.get(1));
        assertEquals(parkingLot1, parkingPotSelectResults.get(2));
        assertEquals(parkingLot2, parkingPotSelectResults.get(3));
        assertEquals(parkingLot1, parkingPotSelectResults.get(4));
    }

    @Test
    void should_return_0001_when_parking_1_larger_available_position_than_parking_2_given_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot1.setParkSpace(4);
        parkingLot2.setParkSpace(7);
        ParkingBoy parkingBoy = new SuperSmartBoy(Arrays.asList(parkingLot1, parkingLot2));

        // when
        CarTicket ticket = null;
        for (int i = 0; i < 11; i++) {
            ticket = parkingBoy.parkCar(new Car());
        }

        // then
        assertNotNull(ticket);
        assertEquals(parkingLot2, ticket.getParkingLot());
    }

    @Test
    void should_return_0002_when_parking1_7_capacity_parking2_3_capacity_given_8_car() {
        // given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot1.setCapacity(7);
        parkingLot1.setCapacity(3);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        // when
        CarTicket ticket = null;
        for (int i = 0; i < 8; i++) {
            ticket = parkingBoy.parkCar(new Car());
        }

        // then
        assertEquals(parkingLot2, ticket.getParkingLot());
    }

}
