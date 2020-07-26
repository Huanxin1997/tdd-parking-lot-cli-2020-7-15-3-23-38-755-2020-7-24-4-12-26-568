package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotServiceManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotServiceManagerTest {
    @Test
    void should_return_true_when_add_parking_boy_capacity_given_1_parking_boy() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        List parkingBoys = new ArrayList(Arrays.asList(parkingBoy));
        ParkingLotServiceManager manager = new ParkingLotServiceManager(parkingBoys);

        // when
        Boolean result = manager.addParkingBoy(parkingBoy);
        // then
        Assertions.assertEquals(true, result);
    }
}
