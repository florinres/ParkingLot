<%--
  Created by IntelliJ IDEA.
  User: nxg06737
  Date: 06.12.2024
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Edit Car">

    <form class="needs-validation was-validated" novalidate method="post" action="${pageContext.request.contextPath/EditCar}">
        <div class="row g-3">
            <div class="col-sm-6">
                <label for="license_plate" class="form-label">License Plate</label>
                <input type="text" class="form-control" name="license_plate" id="license_plate" placeholder="" value="${car.licensePlate}" required="">
                <div class="invalid-feedback">
                    Valid license plate is required.
                </div>
            </div>
        </div>

        <div class="row g-3">
            <div class="col-sm-6">
                <label for="parking_spot" class="form-label">Parking Spot</label>
                <input type="text" class="form-control" name="parking_spot" id="parking_spot" placeholder="" value="${car.parkingSpot}" required="">
                <div class="invalid-feedback">
                    Valid parking spot is required.
                </div>
            </div>
        </div>

        <select class="custom-select d-block w-100" id="owner_id" name="owner_id" required>
            <option value="">Select Owner</option>
                <c:forEach var="user" items="${users}">
                    <option value="${user.id}" ${car.owner eq user.username ? 'selected' : ''}>${user.username}</option>
                </c:forEach>
        </select>

        <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
        <input type="hidden" name="car_id" value="${car.id}">
    </form>

</t:pageTemplate>
