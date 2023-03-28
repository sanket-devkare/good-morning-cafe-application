<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Add/Update Recipe Form</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/commoncss.css" />
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/recipe-formcss.css" />
	</head>
	<body>
		<header>
        	<h1>Good Morning<br> Café !!</h1>
    	</header>
    	<br>
		
		<div class="button">
        	<input type="button" value="Go Back" 
        	onclick="window.location.href='showRecipeList'; return false;" />
    	</div>

	    <div class="pageTitle">
	        <h3>Recipe Form</h3>
	    </div>
    	<br>
		
		<main>
        	<img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg2.jpg">
	        <section>
	            <form:form action="addRecipe" modelAttribute="recipe">
	            <form:hidden path="recipeId"/>
	                <table>
	                    <tr>
	                        <td class="label"><label>Recipe Name: </label></td>
	                        <td><form:input class="input" type = "text" path="recipeName"/>
	                            <br><span class = "error">${recipeErrorMesage}</span>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td class="label"><label>Make Available: </label></td>
	                        <td>
	                            <form:select class="select" path="isAvailable">
	                                <form:option value="true">YES</form:option>
	                                <form:option value="false">NO</form:option>
	                            </form:select>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td class="label"><label>Cost: </label></td>
	                        <td><form:input class="input" type = "text" path="cost"/>
	                            <br><span class = "error">${costErrorMesage}</span>
	                        </td>
	                    </tr>
	                </table>
	                <br>
	                <div class="button">
	                    <input type = "submit" value="Add Recipe" 
	                        onclick="if (!(confirm('Are you sure you want to proceed with this recipe?'))) return false"/>
	                </div>
	            </form:form>
	        </section>
    </main>

	</body>
	
</html>
