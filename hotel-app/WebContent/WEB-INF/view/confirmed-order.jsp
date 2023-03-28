<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Order Confirm</title>
		<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/confirmed-ordercss.css" />
	</head>
	<body>
		<header>
        	<h1>Good Morning<br> Café !!</h1>
			<div class="address">
            Nh-48 (Pune-Banglore Highway),<br>
			Dist - Satara, Pin: 415001,<br>
            Phone (02162) 252809
			</div>
		</header>
		<br>
		<table class="detailsTable">
	        <tr>
	            <td class="leftColumn">
	                <span>Receipt No. : </span><span>${savedConfirmedOrder.orderId}</span>
	            </td>            
	        </tr>
	        <tr>
	            <td class="leftColumn">
	                <span>Table No. : </span><span>${savedConfirmedOrder.tableNumber}</span>
	            </td>
	            <td class="rightColumn">
	                <span>Date : </span><span>${savedConfirmedOrder.orderDate}</span>
	            </td>
	        </tr>
    	</table>
		<hr>
		
		<table class="orderDetailsTable">
			<tr>
				<th>Item</th>
				<th>Qty</th>
				<th>Rate(INR)</th>
				<th>Amount(INR)</th>
			</tr>
			<c:forEach var="entry" items="${billList}">
				<tr>
					<td class="billItems">${entry.item}</td>
					<td class="billItems">${entry.quantity}</td>
					<td class="billItems">${entry.rate}</td>
					<td class="billItems">${entry.amount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td class="billItems">Total Bill : </td>
				<td class="billItems">${savedConfirmedOrder.totalBill}</td>
			</tr>
		</table>
		
		<br>
		<div class="button">
			<input type="button" value="Pay Bill" 
			onclick="window.location.href='returnToHomePage'; return false;"/>
		</div>

	</body>

</html>