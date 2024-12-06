package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBAccessException;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

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
        emf = Persistence.createEntityManagerFactory("ParkingLot");
        em =  emf.createEntityManager();
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
            if (car == null) {
                System.out.println("Null car found, skipping...");
                continue;
            }
            // Procesare normală
            Long id = car.getId();
            String licensePlate = car.getLicensePlate();
            String parkingSpot = car.getParkingSpot();
            String owner = car.getOwner().getUsername();
            dtos.add(new CarDto(owner, parkingSpot, licensePlate, id));
        }
            return dtos;
    }

    public void createCar(String licensePlate, String parkingSpot, Long userId) {
        LOG.info("createCar");

        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user = em.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        em.persist(car);
    }
}
