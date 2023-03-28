<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Admin Login Page</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/admin-logincss.css" />
	</head>
	<body>
		<main>
	        <header>
	            <h1>Good Morning<br> Café !!</h1>
	        </header>
	        <div class="pageTitle">
	            <h3>Login</h3>
	            <p class="errorMessage">${errorMessage}</p>
	        </div>
	        <section>
	            <form:form class="form" action="adminControl" modelAttribute="adminLogin">
	                <table>
	                    <tr>
	                        <td><form:input class="inputFeild" path="userId" type="text" placeholder="Username" /></td>
	                    </tr>
	                    <tr>
	                        <td><form:input class="inputFeild" path="password" type="password" placeholder="Password" /></td>
	                    </tr>       
	                </table>
	                
	                <div class="button">
	                    <input type="submit" value="Login"/>
	                </div>
	                
	            </form:form>
	        </section>
    </main>
	</body>
</html>