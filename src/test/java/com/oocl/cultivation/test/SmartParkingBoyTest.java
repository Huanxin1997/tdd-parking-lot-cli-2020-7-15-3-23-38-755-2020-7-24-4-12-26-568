package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_return_parkingLot1_when_parking_1_more_than_parking_2_given_car() {
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
}
