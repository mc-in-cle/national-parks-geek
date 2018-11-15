<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp">
	<c:param name="pageTitle" value="National Parks Geek"/>
</c:import>

<body>

<div id = "main-content">
	
	<c:forEach var="park" items="${parksList }">
		<c:url var="parkImgUrl" value="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
		<table class="parkInfoTable">
		<tr>
			<td>
				<img class="parkImg" src="${parkImgUrl }" alt="${park.parkName }"/>
			</td>
			<td>
				<a href="parkDetails?parkCode=${park.parkCode }">
					<h3 class="parkInfoHeader">${park.parkName } &mdash; ${park.state }</h3>
				</a>
				<p class="parkDescription">${park.parkDescription }</p>
			</td>
		</tr>
		</table>
	</c:forEach>
</div>

</body>
</html>