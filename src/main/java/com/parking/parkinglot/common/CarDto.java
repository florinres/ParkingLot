package com.parking.parkinglot.common;

public class CarDto {
    Long id;
    String licensePlate;
    String parkingLot;
    String ownerName;

    public CarDto(String ownerName, String parkingLot, String licensePlate, Long id) {
        this.ownerName = ownerName;
        this.parkingLot = parkingLot;
        this.licensePlate = licensePlate;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public String getOwnerName() {
        return ownerName;
    }


}
