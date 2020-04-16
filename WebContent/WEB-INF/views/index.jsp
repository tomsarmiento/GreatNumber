<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Great Number Game</title>
		<script src= 'http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
	</head>
	<body>
		<div class="welcome">
			<h2> Welcome to the Great Number Game! </h2>
			<h3> Choose a range:</h3>
			<form action="RangeChosen" method="post" class="form1">
				<label for="from">From:</label>
				<input type="number" name="minimum" step="1" required="required">
				<label for="to">To:</label>
				<input type="number" name="maximum" step="1" required="required">
				<br><br>
				<input type="submit" value="Submit">
			</form>
		</div>
	</body>
</html>