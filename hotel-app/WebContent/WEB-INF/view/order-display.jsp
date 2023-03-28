<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Order Display</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/commoncss.css" />
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/order-displaycss.css" />
		
	</head>
	<body>
		<header>
        	<h1>Good Morning<br> Café !!</h1>
    	</header>
		<br>
    	<div class="pageTitle">
        	<h3>Enter Quantity</h3>
    	</div>
		
		<main class="bg1">
        <img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg1.jpg">
        <section>
            <form:form action="toConfirmOrder" modelAttribute="order">
            <div class="tableNumber">
                <label> Table No. : </label><form:input class = "tableNumberInput" path="tableNumber"/>
            </div>
            <br>    
                <table>
                    <tr>
                        <th>Recipe</th>
                        <th>Quantity</th>
                    </tr>
                    <c:forEach var="recipe" items="${order.recipeList}">
                    <tr>
                        <td><form:input class = "recipeInput" value="${recipe}" path="recipeList" /></td>
                        <td><form:input class = "input" type="text" path="quantityList" /></td>
                    </tr>
                    </c:forEach>
                </table>
                <br>
                <div class="button">
                    <input type="submit" value="Order" 
                    onclick="if (!(confirm('Are you sure you want to confirm this order?'))) return false"/>
                </div>
                
            </form:form>
            </section>
    </main>
		
	</body>

</html>