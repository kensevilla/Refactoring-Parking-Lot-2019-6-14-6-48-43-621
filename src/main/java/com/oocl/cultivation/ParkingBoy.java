package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingBoy{
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingLotList.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        this.parkingLot = parkingLotList.get(0);
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

    public ParkingTicket park(Car car) {
        chooseParkingLot();
        return parkingLot.parkCar(car);
    }

    public Car fetch(ParkingTicket ticket) {
      return Objects.requireNonNull(parkingLotList.stream().
              filter(a -> a.getCars().containsKey(ticket)).
              findFirst().
              orElse(this.parkingLot)).fetchCar(ticket);
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
