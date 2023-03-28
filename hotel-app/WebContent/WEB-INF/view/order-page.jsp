<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Order Page</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/commoncss.css" />
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/order-pagecss.css" />
		<style>
			.errorMess{
				color: red;
				font-size: 30px;
			}
		</style>
	</head>
	<body>
		<header>
        	<h1>Good Morning<br> Café !!</h1>
    	</header>
		
		<div class="leftMargin">
			<a href="${pageContext.request.contextPath}/hotel/home">To Homepage</a>
		</div>
		
		<div class="pageTitle">
        	<h3>Order Select</h3>
    	</div>
		
		<main class="bg1">
		<img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg1.jpg">
		<section>
			<form:form action="toOrderDisplay" modelAttribute="order">
				<div class="tableNumber">
					<label>Table No. : </label><form:input class="input" path="tableNumber"/>
				</div>
				<br>
					<div class="errorMess">${errorMessage}</div>
				<br>
				<table>
					<tr>
						<th>Recipe</th>
						<th>Cost</th>
						<th>Checked</th>
					</tr>
					<c:forEach var="recipe" items="${availableRecipeList}">
					
					<tr>
						<td>${recipe.recipeName}</td>
						<td>${recipe.cost}</td>
						<td class="checkbox"><form:checkbox path="recipeList" value="${recipe.recipeName}"/></td>
					</tr>
					
					</c:forEach>
				</table>
				<br>
				<div class="button">
					<input type="submit" value="Order"/>
				</div>
				
			</form:form>
		</section>	
	</main>
		
	</body>

</html>