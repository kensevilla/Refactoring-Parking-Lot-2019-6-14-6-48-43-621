package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    int getCapacity() {
        return capacity;
    }

    private Map<ParkingTicket, Car> cars = new HashMap<>();
    String getAlertMessage() {
        return alertMessage;
    }

    private String alertMessage;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        int availableParkingPosition = capacity - cars.size();
        if(availableParkingPosition <= 0) {
            alertMessage = "Not enough position.";
        }
        return availableParkingPosition;
    }

    ParkingTicket parkCar(Car car){
        if(getAvailableParkingPosition()>0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            cars.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    Car fetchCar(ParkingTicket parkingTicket){
        if(parkingTicket == null) {
            alertMessage =  "Please provide your parking ticket.";
            return null;
        }

        Car car = cars.get(parkingTicket);
        if (car != null) {
            cars.remove(parkingTicket);
        } else {
            alertMessage = "Unrecognized parking ticket";
        }
        return car;
    }

    public Map<ParkingTicket, Car> getCars(){
        return cars;
    }
}
