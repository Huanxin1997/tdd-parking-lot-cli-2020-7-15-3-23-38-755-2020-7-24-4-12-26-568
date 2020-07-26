package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParkingLotServiceManagerTest {
    @Test
    void should_return_true_when_add_parking_boy_capacity_given_1_parking_boy() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingBoy> parkingBoys = new ArrayList<>(Collections.singletonList(parkingBoy));
        ParkingLotServiceManager manager = new ParkingLotServiceManager(parkingBoys);

        // when
        Boolean result = manager.addParkingBoy(parkingBoy);
        // then
        Assertions.assertEquals(true, result);
    }

    @Test
    void should_return_parking_boy_2_when_specify_boy_given_parking_boy_2() {
        // given
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingBoy parkingBoy3 = new ParkingBoy();
        List<ParkingBoy> parkingBoys = new ArrayList<>(Arrays.asList(parkingBoy1, parkingBoy2, parkingBoy3));
        ParkingLotServiceManager manager = new ParkingLotServiceManager(parkingBoys);

        // when
        ParkingBoy specifiedParkingBoy = manager.specifyBoy(parkingBoy2);

        // then
        Assertions.assertNotNull(specifiedParkingBoy);
        Assertions.assertEquals(parkingBoy2, specifiedParkingBoy);
    }

    @Test
    void should_return_true_when_specify_boy_parking_car_given_parking_boy_2() {
        // given
        ParkingLot parkingLot1 = new ParkingLot("0001");
        ParkingLot parkingLot2 = new ParkingLot("0002");
        ParkingBoy parkingBoy1 = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 1);
        ParkingBoy parkingBoy2 = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 2);
        ParkingBoy parkingBoy3 = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2), 3);
        List<ParkingBoy> parkingBoys = new ArrayList<>(Arrays.asList(parkingBoy1, parkingBoy2, parkingBoy3));
        ParkingLotServiceManager manager = new ParkingLotServiceManager(parkingBoys);

        // when
        ParkingBoy specifiedParkingBoy = manager.specifyBoy(parkingBoy2);
        CarTicket ticket = specifiedParkingBoy.parkCar(new Car());

        // then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_2_when_specify_parking_lot_given_2_parking_lots() {
        // given
        ParkingLot parkingLot1 = new ParkingLot("0001");
        ParkingLot parkingLot2 = new ParkingLot("0002");
        ParkingLotServiceManager manager = new ParkingLotServiceManager();

        // when
//        manager.setParkingLots(Arrays.asList(parkingLot1, parkingLot2));
        manager.addParkingLot(parkingLot1);
        manager.addParkingLot(parkingLot2);
        int parkingLotCount = manager.getParkingLots().size();

        // then
        Assertions.assertEquals(2, parkingLotCount);
    }

    @Test
    void should_return_ticket_when_park_given_car() {
        // given
        ParkingLotServiceManager manager = new ParkingLotServiceManager();

        // when
        CarTicket ticket = manager.parkCar(new Car());

        // then
        Assertions.assertNotNull(ticket);
    }
}
