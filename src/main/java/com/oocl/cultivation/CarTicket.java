package com.oocl.cultivation;

public class CarTicket {
    private Boolean effectiveness = true;

    public CarTicket(Boolean effectiveness) {
        this.effectiveness = effectiveness;
    }

    public CarTicket() {
    }

    public Boolean getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(Boolean effectiveness) {
        this.effectiveness = effectiveness;
    }
}
