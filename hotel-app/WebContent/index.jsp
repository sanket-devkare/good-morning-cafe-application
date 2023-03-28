<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Hotel Intro Page</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/maincss.css" />
	</head>
	<body>
		<header>
        	<h1>Good Morning<br> Café !!</h1>
    	</header>
		
		<main class="bg1">
			<img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg1.jpg">
			<section>
	            <article>
	                <p>Welcome to Good Morning Cafe`. This is a Restaurant Order-Management Online 
	                    Application that is developed so that the customer can himself place his order through this application
	                    without calling out for waiter or waiting for waiter to take the order. 
	                    This application shows the customer, the Dishes/Recipes that are available in 
	                    the Main Menu page so that the customer can select the Recipes he wants to order. 
	                    After that customer needs to enter the quantity of those dishes and finally, 
	                    this application gives out a Receipt with total Bill Amount to be paid.</p>
	                <p>On the other hand this application is beneficial for the management of the 
	                    Restaurant, where the employees/Manager of the Restaurant can login to the 
	                    application using the login credentials provided. After logging in, the Manager 
	                    is able to see the list all the recipes that can be served in the Restaurant along 
	                    with their cost. He can perform certain operations on the list of these recipes 
	                    such as <br> i) Adding a new Recipe,<br> ii) Changing the Names or 
	                    Selling Price of the Recipe,<br> iii) Deleting the recipe from 
	                    the list,<br> iv) Making a recipe Available/Not-Available for the 
	                    customer.<br> This application becomes more beneficial in analyzing 
	                    the sales of the Recipes, as it also tracks and displays the count of 
	                    orders and revenue generated for current date and for past 7 days.</p>    
	                <p>The Technologies involved for development of the application are mainly 
	                    Spring Boot, Spring MVC, Spring Hibernate, SQL, HTML, CSS etc.</p>
	            </article> 
		        <br>
		        <a href="/hotel-app//hotel/home">Proceed >></a>
	        </section>
        </main>
	</body>

</html>