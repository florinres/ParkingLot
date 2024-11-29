package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBAccessException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

@Stateless
public class CarsBean {


    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    private EntityManager em;
    EntityManagerFactory emf;

    public List<CarDto> findAllCars() {
        LOG.info("findAllCars");
        try {
            TypedQuery<Car> typedQuery = em.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception e) {
            throw new EJBAccessException();
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> dtos = new ArrayList<>();
        for (Car car : cars) {
            Long id = car.getId();
            String licensePlate = car.getLicensePlate();
            String parkingSpot = car.getParkingSpot();
            String owner = car.getOwner().getUsername();
            dtos.add(new CarDto(owner, parkingSpot, licensePlate, id));
        }

        return dtos;
    }
}
