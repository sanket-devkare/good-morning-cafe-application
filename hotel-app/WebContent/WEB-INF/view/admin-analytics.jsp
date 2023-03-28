
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
		href="${pageContext.request.contextPath}/resources/css/admin-analyticscss.css" />
	</head>
	<body>
		<header>
	        <h1>Good Morning<br> Café !!</h1>
	    </header>
	    
	    <div class="adminloginbutton">
	        <input type="button" value="Logout" 
	        onclick="window.location.href='home'; return false;" />
	    </div>
	    
	    <div class="pageTitle">
	        <h3>Revenue and Order Analytics</h3>
	    </div>	
	    
		<main  class="bg1">
	        <img alt="background1" src="${pageContext.request.contextPath}/resources/images/bg2.jpg">
	        <section>
	            <table>
	                <tr>
	                    <td>
	                        <div class="infoTile">
	                            <span class="infoTitle">Revenue Past 7 Days: </span><hr>
	                            <span class="infoResult">${analytics.revenueThisWeek}.00</span>
	                        </div>
	                    </td>
	                    <td>
	                        <div class="infoTile">
	                            <span class="infoTitle">Revenue Today: </span><hr>
	                            <span class="infoResult">${analytics.revenueToday}.00</span>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <div class="infoTile">
	                            <span class="infoTitle">Number of Orders Served Past 7 Days: </span><hr>
	                            <span class="infoResult">${analytics.orderCountWeek}</span>
	                        </div>
	                    </td>
	                    <td>
	                        <div class="infoTile">
	                            <span class="infoTitle">Number of Orders Served Today: </span><hr>
	                            <span class="infoResult">${analytics.orderCountToday}</span>
	                        </div>
	                    </td>
	                </tr>
	            
	            </table>	
	            <br>
	
	            <div class="recipeButton">
	                <span>Show Recipe List :</span>
	                <div class="button">
	                    <input type="button" value="Show Recipes" 
	                    onclick="window.location.href='showRecipeList'; return false;"/>
	                </div>
	            </div>
	        </section> 
    	</main>
	</body>
</html>