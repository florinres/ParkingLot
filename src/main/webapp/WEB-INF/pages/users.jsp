<%--
  Created by IntelliJ IDEA.
  User: rares
  Date: 06.12.2024
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<t:pageTemplate pageTitle="Users">
  <h1>Users</h1>
  <:c:forEach var="user" items="${users}">
    <div class="container text-center">
        <div class="row">
          <div class="col">
              ${user.id}
          </div>
          <div class="col">
              ${user.email}
        </div>
      </div>
  </:c:forEach>
  <h5>Number of users: ${numberofusers}</h5>
</t:pageTemplate>