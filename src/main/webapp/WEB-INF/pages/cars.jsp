<%--
  Created by IntelliJ IDEA.
  User: Rares Bolca
  Date: 08.11.2024
  Time: 08:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
<h1>Cars</h1>
    <div class="container text-center">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddCar">Add Car</a>
        <c:forEach var="car" items="${cars}">
            <div class="row">
                <div class="col">
                        ${car.licensePlate}
                </div>
                <div class="col">
                        ${car.parkingSpot}
                </div>
                <div class="col">
                        ${car.ownerName}
                </div>
            </c:forEach>
        </div>
    </div>
    <h5>Free Parking Spots: ${free_parking_spots}</h5>
</t:pageTemplate>