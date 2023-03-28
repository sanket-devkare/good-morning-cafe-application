<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Hotel Homepage</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/commoncss.css" />
	</head>
	<body>
		<header>
			<h1>Good Morning<br> Café !!</h1>
		</header>
		
		<div class="adminloginbutton">
        	<input type="button" value="Admin Login" 
        	onclick="window.location.href='loginPage'; return false;"/>
    	</div>
    	
    	<div class="pageTitle">
        	<h3>Break-fast Menu</h3>
    	</div>
		
		
		<main class="bg1">
			<img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg1.jpg">
			<section>
	            <table>
	                <tr>
	                    <th>Recipe</th>
	                    <th>Cost</th>
	                </tr>
	                <c:forEach var="recipe" items="${recipeList}">
	                <tr>
	                    <td>${recipe.recipeName}</td>
	                    <td>${recipe.cost}.00</td>
	                </tr>
	                    
	                </c:forEach>
	            </table>
            <br>
	            <div class="button">
	                <input type="button" value="Order" 
	                onclick="window.location.href='orderPage'; return false;"/>
	            </div>
        	</section>
		</main>	
	</body>
</html>