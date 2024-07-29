<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
	  	display: flex;
	    justify-content: center;
	    align-items: center;
	    min-height: 100vh;
	    background: url("https://b.zmtcdn.com/web_assets/81f3ff974d82520780078ba1cfbd453a1583259680.png") no-repeat;
	    background-size: cover;
	    background-position: center;
	}

	.container {
	  width: 35%;
	  margin: 50px auto;
	  background-color: #fff;
	  padding: 20px;
	  border: 2px solid rgba(255, 255, 255, .5);
      border-radius: 10px;
	  align-items: center;
	}
	
	select, button {
	  display: block;
	  width: 95%;
	  margin-bottom: 15px;
	  padding: 10px;
	  border: 1px solid #ccc;
	  border-radius: 5px;
	  font-size: 16px;
	}
	select{
		background: transparent;
		color: black;
		font-size: 1.2em;
	}
	button {
	  width: 80%;
	  background-color: rgb(239, 79, 95);
	  color: #fff;
	  border: none;
	  cursor: pointer;
	  letter-spacing: 1.6px;
	  transition: 0.4s;
	}
	
	button:hover {
	  opacity: 0.9;
	}
	input[type="text"] {
	  width: 90%;
	  padding: 10px;
	  border: 1px solid #ccc;
	  border-radius: 5px;
	  font-size: 1.2em;
	  outline: none;
	  margin-bottom: 2%;
	  background: transparent;
	  
	}
	input[type="text"]:focus {
	  border-color: #007bff;
	  box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
	}
	h1{
		text-align: center;
		color: rgb(239, 79, 95);
		letter-spacing: 1.6px;
	}
	#cardNumber{
		width: 240px;
		float: left;
		margin-left: 14px;
		margin-top: 3px;
	}
	#expiryDate{
		width: 100px;
		margin-top: -180px;
	}
	#cardHolderName{
		width: 240px;
		float: left;
		margin-left: 14px;
		margin-top: 3px;
	}
	#cvc{
		width: 100px;
		margin-top: -180px;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>Check Out</h1>
		<form id="myForm" action="checkOutServlet" method="post">
			<center><input type="text" id="myInput" placeholder="Enter Address..." name="address"></center>
			<center><select id="paymentMode" name="payment" onchange="showFields()">
				<option value="Select Payment Mode">Select Payment Mode</option>
				<option value="Card">Card</option>
				<option value="COD">COD</option>
				<option value="UPI">UPI</option>
			</select></center>
		
		<center><button type="submit">Submit</button></center>
		
		</form>
	</div>
	
</body>
</html>