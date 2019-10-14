package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy{
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        if(this.parkingLotList.isEmpty()) {
            this.parkingLotList.add(parkingLot);
        }
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        if(parkingLot == null) {
            this.parkingLot = parkingLotList.get(0);
        }
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        if(this.parkingLotList.isEmpty()) {
            this.parkingLotList.add(parkingLot);
        }
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        if(parkingLot == null) {
            this.parkingLot = parkingLotList.get(0);
        }
    }

    public ParkingTicket park(Car car) {
        chooseParkingLot();
        return parkingLot.parkCar(car);
    }

    public Car fetch(ParkingTicket ticket) {
        for(ParkingLot tempParkingLot : parkingLotList){
            Car car = tempParkingLot.fetchCar(ticket);
            if(car != null){
                return car;
            }
        }
        return null;
    }

    public void chooseParkingLot() {
        this.parkingLot = this.parkingLotList.stream()
                .filter(tempParkingLot -> tempParkingLot.getAvailableParkingPosition()>0)
                .findFirst()
                .orElse(this.parkingLot);
    }

    public String getLastErrorMessage() {
        return this.parkingLot.getAlertMessage();
    }
}
