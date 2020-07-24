package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_car_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket = parkingLot.parkCar(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_given_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket = parkingLot.parkCar(car);
        Car fetchedCar = parkingLot.fetchCar(ticket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(fetchedCar, car);
    }

    @Test
    void should_return_2_tickets_when_park_2_cars() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket1 = parkingLot.parkCar(car1);
        CarTicket ticket2 = parkingLot.parkCar(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_correspond_ticket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket1 = parkingLot.parkCar(car1);
        CarTicket ticket2 = parkingLot.parkCar(car2);
        Car fetchedCar1 = parkingLot.fetchCar(ticket1);
        Car fetchedCar2 = parkingLot.fetchCar(ticket2);

        //then
        assertNotNull(fetchedCar1);
        assertNotNull(fetchedCar2);
        assertEquals(fetchedCar1, car1);
        assertEquals(fetchedCar2, car2);
    }

    @Test
    void should_return_false_when_fetch_car_given_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket = parkingLot.parkCar(car);
        CarTicket wrongTicket = new CarTicket();
        Car fetchedCar = parkingLot.fetchCar(wrongTicket);

        //then
        assertEquals(null, fetchedCar);
    }
}
