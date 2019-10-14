package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceManager extends ParkingBoy{
    public void setManagementList(List<ParkingBoy> managementList) {
        this.managementList = managementList;
    }

    private List<ParkingBoy> managementList = new ArrayList<>();
    public ParkingServiceManager(ParkingLot parkingLot){
        super(parkingLot);
    }

    public ParkingTicket askToPark(ParkingBoy parkingBoy, Car car) {
        if(managementList.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }

    public Car askToFetch(ParkingBoy smartParkingBoy, ParkingTicket parkingTicket) {
        if (managementList.contains(smartParkingBoy)) {
            return smartParkingBoy.fetch(parkingTicket);
        }
        return null;
    }
}
