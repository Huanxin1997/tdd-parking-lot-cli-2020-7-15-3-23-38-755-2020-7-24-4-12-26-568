package com.oocl.cultivation;

import java.util.List;

public class ParkingLotServiceManager {
    private List<ParkingBoy> parkingBoys;

    public ParkingLotServiceManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Boolean addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
        return parkingBoys.get(parkingBoys.size() - 1) == parkingBoy;
    }

    public ParkingBoy specifyBoy(ParkingBoy expectedParkingBoy) {
        for(ParkingBoy parkingBoy : parkingBoys) {
            if(parkingBoy == expectedParkingBoy) {
                return expectedParkingBoy;
            }
        }
        return null;
    }
}
