<%--
  Created by IntelliJ IDEA.
  User: rares
  Date: 30.11.2024
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Cars</h1>
    <div class="container text-center">
        <c:forEach var="user" items="${users}">
            <div class="row">
                <div class="col">
                        ${user.licensePlate}
                </div>
                <div class="col">
                        ${user.parkingSpot}
                </div>
                <div class="col">
                        ${user.ownerName}
                </div>
            </div>
        </c:forEach>
    </div>
    <h5>Number of users: ${numberofusers}</h5>
</t:pageTemplate>