<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		  crossorigin="anonymous">

	<title>${title}</title>
	<br>

</head>

<body>

<div class="jumbotron">

	<div class="container">
		<h1>${welcome}</h1>
		<br>
	</div>

	<div class="container">
		<form action="<c:url value="play"/>">
			<h2>
				<button type="submit">${playButton}</button>
			</h2>
		</form> <br>

		<c:if test="${!empty games}">
			<table cellpadding="20" bordercolor="666633">
				<!-- This table display all the games... -->
				<tr>
					<th><c:out value="${playerChoice}" /></th>
					<th><c:out value="${computerChoice}" /></th>
					<th><c:out value="${result}" /></th>
				</tr>
				<c:forEach var="game" items="${games}">
					<tr>
						<td><c:out value="${game.playerChoice}" /></td>
						<td><c:out value="${game.computerChoice}" /></td>
						<td><c:out value="${game.result}" /></td>
					</tr>
				</c:forEach>
			</table> <br>
		</c:if>

		<form action="<c:url value="restart"/>">
			<h2>
				<button type="submit">${restartButton}</button>
			</h2>
		</form> <br>
	</div>

	<footer class="footer">
		<div class="container">
			<c:out value="${rounds}" />
			<c:out value="${numGames}" />
			<br> <a href="/stats">${goToStats}</a> <br>
		</div>
	</footer>
</div>

</body>
</html>