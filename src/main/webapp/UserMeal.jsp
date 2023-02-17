<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

<<<<<<< HEAD
        .exceed {
=======
        .excess {
>>>>>>> main
            color: red;
        }
    </style>
</head>
<body>
<<<<<<< HEAD
<section>
    <h3><a href="index.html">Home</a></h3>
    <h3><a href="/Open-pet3/userMeals?action=create">Add Meal</a></h3>
=======
+<section>
   <h3><a href="index.html">Home</a></h3>
>>>>>>> main
    <hr/>
    <h2>Meals</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
<<<<<<< HEAD
            <jsp:useBean id="meal" scope="page" type="edu.tampa.open_pet3.model.UserMealWithExceed"/>
            <tr class="${meal.exceed ? 'exceed' : 'normal'}">
                <td>
                        <fmt:parseDate value="${meal.localDateTime}" pattern="y-M-dd'T'H:m" var="parseDate"/>
                        <fmt:formatDate value="${parseDate}" pattern="yyyy.MM.dd HH:mm"/>
                 </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="/Open-pet3/userMeals?action=update&id=${meal.mealId}">UPDATE</a></td>
                <td><a href="/Open-pet3/userMeals?action=delete&id=${meal.mealId}">DELETE</a></td>
=======
            <jsp:useBean id="meal" type="edu.tampa.open_pet3.model.MealTo"/>
            <tr class="${meal.excess ? 'excess' : 'normal'}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                       <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        <%--${fn:replace(meal.dateTime, 'T', ' ')}--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
>>>>>>> main
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>