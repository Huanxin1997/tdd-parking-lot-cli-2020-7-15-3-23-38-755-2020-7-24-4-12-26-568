package com.oocl.cultivation;

public class CarTicket {
    private Boolean effectiveness = true;
    private String parkingLotId = "";

    public CarTicket(Boolean effectiveness) {
        this.effectiveness = effectiveness;
    }

    public CarTicket(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public CarTicket() {
    }

    public Boolean getEffectiveness() {
        return effectiveness;
    }

    public String getParkingLotId() {
        return this.parkingLotId;
    }
}
