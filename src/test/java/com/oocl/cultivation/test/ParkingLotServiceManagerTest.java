package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotServiceManager;
import org.junit.jupiter.api.Assertions;
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
}
