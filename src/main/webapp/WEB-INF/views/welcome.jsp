<%--
  Created by IntelliJ IDEA.
  User: Antonella
  Date: 5/8/17
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <title>Hibernate Demo</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Hibernate Example</h1>
        <p>This examples uses the Northwind DB</p>
    </div>
    <a href="welcome">Reload Page</a> <br>
    <a href="getNewCust">Add a Customer</a>
    <br>
    <form action="searchByCity" method="get">
        <input type="text" name="city">
        <input type="submit" value="search">
    </form>
    <form action="dropdownMenu" method="get">
        <select name="country" onchange="this.form.submit()">
            <option value="null">Select Country</option>
            <option value="uk">UK</option>
            <option value="germany">Germany</option>
            <option value="usa">USA</option>
            <option value="denmark">Denmark</option>
            <option value="mexico">Mexico</option>
            <option value="sweden">Sweden</option>
            <option value="france">France</option>
            <option value="spain">Spain</option>
            <option value="canada">Canada</option>
            <option value="argentina">Argentina</option>
        </select>
        <%--<input type="submit" value="search">--%>
    </form>
    <br>


    <table border=1>
        <c:forEach var="myvar" items="${cList}">
            <tr>
                <td> ${myvar.customerId}</td>
                <td> ${myvar.companyName}</td>

                <td><a href="delete?id=${myvar.customerId}"> Delete </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
