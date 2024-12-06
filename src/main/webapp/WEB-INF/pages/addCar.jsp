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
<t:pageTemplate pageTitle="AddCar">

    <form class="needs-validation was-validated" novalidate method="post" action="/AddCar">
        <div class="row g-3">
            <div class="col-sm-6">
                <label for="license_plate" class="form-label">License Plate</label>
                <input type="text" class="form-control" name="license_plate" id="license_plate" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Valid license plate is required.
                </div>
            </div>
        </div>

        <div class="row g-3">
            <div class="col-sm-6">
                <label for="parking_spot" class="form-label">Parking Spot</label>
                <input type="text" class="form-control" name="parking_spot" id="parking_spot" placeholder="" value="" required="">
                <div class="invalid-feedback">
                    Valid parking spot is required.
                </div>
            </div>
        </div>

        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown button
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach var="user" items="${users}" varStatus="status">
                    <option value="${user.id}">${user.username}</option>
                </c:forEach>
            </div>
        </div>

        <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
    </form>

</t:pageTemplate>
