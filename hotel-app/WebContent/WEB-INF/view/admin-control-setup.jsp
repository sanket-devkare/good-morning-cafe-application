<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Admin Control</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/commoncss.css" />
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/admin-controlcss.css" />
	</head>
	<body>
		<header>
        	<h1>Good Morning<br> Café !!</h1>
    	</header>
    	
    	<table class="buttonTable">
	        <tr>
	            <td class="buttonrow">
	                <div class="button">
	                    <input type="button" value="Go Back" 
	                    onclick="window.location.href='showAdminAnalyticsPage'; return false;" />
	                </div>
	            </td>
	            <td class="buttonrow">
	                <div class="adminloginbutton">
	                    <input type="button" value="Logout" 
	                    onclick="window.location.href='home'; return false;" />
	                </div>
	            </td>
	        </tr>
    	</table>
    	
    	<br>
	    <div class="pageTitle">
	        <h3>Recipe List</h3>
	    </div>
		
		<main>
        	<img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg2.jpg">
	        <section>
	            <div class="button">
	                <input type="button" value="Add Recipe" 
	                onclick="window.location.href='showRecipeForm'; return false;" />
	            </div>
	            <br>
	            <table>
	                <tr>
	                    <th>Recipe Id</th>
	                    <th>Recipe Name</th>
	                    <th>Is Available</th>
	                    <th>Cost</th>
	                    <th>Action</th>
	                </tr>
	                <c:forEach var="recipeEntry" items="${recipeList}">
	                
	                <c:url var="updateLink" value="/hotel/showFormForUpdate">
	                    <c:param name="recipeId" value="${recipeEntry.recipeId}"></c:param>
	                </c:url>
	                <c:url var="deleteLink" value="/hotel/deleteRecipe">
	                    <c:param name="recipeId" value="${recipeEntry.recipeId}"></c:param>
	                </c:url>
	                
	                <tr>
	                    <td>${recipeEntry.recipeId}</td>
	                    <td>${recipeEntry.recipeName}</td>
	                    <td>${recipeEntry.isAvailable}</td>
	                    <td>${recipeEntry.cost}</td>
	                    <td><a href="${updateLink}">Update</a> | 
	                        <a href="${deleteLink}" 
	                        onclick="if (!(confirm('Are you sure you want to delete this recipe?'))) return false">Delete</a></td>
	                </tr>		
	                </c:forEach>
	        
	            </table>
	        </section>
    	</main>
			
	</body>
</html>

