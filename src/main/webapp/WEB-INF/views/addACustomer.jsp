<%--
  Created by IntelliJ IDEA.
  User: julieschneider
  Date: 3/7/17
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addCustomer" method="post">
    Customer ID <input type="text" name="custID"> <br>
    Company Name <input type="text" name="compName"> <br>
    Contact Name <input type="text" name="contName"> <br>
    Contact Title <input type="text" name="contTitle"> <br>
    Address <input type="text" name="address"> <br>
    City <input type="text" name="city"><br>
    Region <input type="text" name="region"><br>
    Postal Code <input type="number" name="pCode"><br>
    Country <input type="text" name="country"><br>
    Phone <input type="number" name="phone"><br>
    Fax <input type="number" name="fax"><br>
    <input type="submit" value="Add">
</form>

</body>
</html>
