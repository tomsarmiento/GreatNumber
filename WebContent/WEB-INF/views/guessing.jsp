<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Great Number Game</title>
		<script src= 'http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
		<script>
			$(document).ready(function(){
				console.log((<c:out value="${attempts}"/>))
				if((<c:out value="${attempts}"/>)==0){
					console.log((<c:out value="${attempts}"/>))
						$('.guessing').hide()
					}
				if((<c:out value="${number}"/>)==(<c:out value="${guessednumber}"/>)){
						$('.guessing').hide()
					}
 			});
		</script>
	</head>
	<body>
		<div class="guessing">
			<h1> I am thinking of a number between <c:out value="${minimum}"/> and <c:out value="${maximum}"/> </h1>
			<h3>Take a guess!</h3>
			<form action="RangeChosen" method="post" class="form2">
				<input type="number" name="numberguessed" class="numguessed" step="1" required="required" >
				<input type="submit" value="Submit">
				<h3 class="attempts">Your number of attempts left: <c:out value="${attempts}"/></h3>
			</form>
		</div>
		<h1 class="winlost"><c:out value="${winlost}"/></h1>
		<h2><c:out value="${answer}"/></h2>
		<a href="Index"><c:out value="${playagain }"/></a>
	</body>
</html>