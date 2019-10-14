package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public void chooseParkingLot() {
        super.setParkingLot(super.getParkingLotList().stream()
                .reduce((a, b) -> a.getAvailableParkingPosition()/a.getCapacity() > b.getAvailableParkingPosition()/b.getCapacity() ? a : b)
                .get());
    }
}
