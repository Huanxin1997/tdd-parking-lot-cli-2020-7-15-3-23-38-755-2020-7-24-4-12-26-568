package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartBoyTest {
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
}
