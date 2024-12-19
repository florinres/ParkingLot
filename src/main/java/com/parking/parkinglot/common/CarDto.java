package com.parking.parkinglot.common;

import com.parking.parkinglot.entities.User;

public class CarDto {
    Long id;
    String licensePlate;
    String parkingSpot;
    User owner;

    public CarDto(User owner, String parkingSpot, String licensePlate, Long id) {
        this.owner = owner;
        this.parkingSpot = parkingSpot;
        this.licensePlate = licensePlate;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public User getOwner() {
        return owner;
    }


}
