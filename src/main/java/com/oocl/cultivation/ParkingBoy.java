package com.oocl.cultivation;

public class ParkingBoy {

    public String receiveTicketFromCustomer(CarTicket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        }

        return "Unrecognized parking ticket.";
    }
}
