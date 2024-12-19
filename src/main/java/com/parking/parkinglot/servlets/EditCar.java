package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.CarsBean;
import com.parking.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.List;

import java.io.IOException;

@WebServlet(name = "EditCar", value = "/EditCar")
public class EditCar extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<UserDto> users = usersBean.findAllUsers();
        request.setAttribute("users", users);
        try {
            String temp = request.getParameter("id");
            Long carId = Long.parseLong(temp);
            CarDto car = carsBean.findById(carId);
            request.setAttribute("car", car);

            request.getRequestDispatcher("/WEB-INF/pages/editCar.jsp").forward(request, response);
        }catch (ServletException e){
            System.err.println("ServletException: " + e);
        }
        finally {
            request.getRequestDispatcher("/WEB-INF/pages/editCar.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String licensePlate = request.getParameter("licensePlate");
        String parkingSpot = request.getParameter("parkingSpot");
        Long carId = Long.parseLong(request.getParameter("car_id"));
        Long userId = Long.parseLong(request.getParameter("owner_id"));


    }
}