package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager {
    private List<ParkingBoy> parkingBoys;
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();;

    public ParkingLotServiceManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public ParkingLotServiceManager() {
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Boolean addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
        for(ParkingLot parkingLot : parkingBoy.getParkingLots()) {
            parkingLots.add(parkingLot);
        }
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

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
