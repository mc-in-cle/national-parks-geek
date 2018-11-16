<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="pageTitle" value="National Parks Geek" />
</c:import>

<body>

	<div id="main-content">
		<h2>Favorite Parks Survey Results</h2>
		<table id="surveyResults">
			<tr>
				<th></th>
				<th>Park</th>
				<th>Number of Votes</th>
			</tr>
			<c:forEach var="park" items="${surveyList }">
				<c:url var="parkImgUrl"
					value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
				<tr>
					<td><img class="parkImg" src="${parkImgUrl }"
						alt="${park.parkName }" /></td>
					<td>${park.parkName }</td>
					<td>${park.votes }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>