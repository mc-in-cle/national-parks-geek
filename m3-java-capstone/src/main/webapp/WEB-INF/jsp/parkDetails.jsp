<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="pageTitle" value="National Parks Geek" />
</c:import>

<body>

	<div id="main-content">

		<c:url var="parkImgUrl"
			value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
		<img class="parkImg" src="${parkImgUrl }" alt="${park.parkName }" />

		<h2 class="parkInfoHeader">${park.parkName }&mdash; ${park.state }</h2>

		<p class="entryfee">Entry Fee: $${park.entryFee}</p>

		<p class="parkDescription">${park.parkDescription }</p>

		<p class="quote">${park.quote}</p>

		<p class="quotesource"> -${park.quoteSource}</p>

		<table>
			<tr>
				<td class="tableHeader">Year Founded:</td>
				<td class="tableInfo">${park.yearFounded}</td>
			</tr>
			<tr>
				<td class="tableHeader">Number of Campsites:</td>
				<td class="tableInfo">${park.numberOfCampsites}</td>
			</tr>
			<tr>
				<td class="tableHeader">Climate:</td>
				<td class="tableInfo">${park.climate}</td>
			</tr>
			<tr>
				<td class="tableHeader">Miles of Trail:</td>
				<td class="tableInfo">${park.trailMiles}</td>
			</tr>
			<tr>
				<td class="tableHeader">Elevation:</td>
				<td class="tableInfo">${park.elevation}ft</td>
			</tr>
			<tr>
				<td class="tableHeader">Number of Animal Species:</td>
				<td class="tableInfo">${park.numberOfAnimalSpecies}</td>
			</tr>
			<tr>
				<td class="tableHeader">Acreage:</td>
				<td class="tableInfo">${park.acreage}</td>
			</tr>

		</table>

		<div class="weather">
			<div class="todayWeather">
				<c:set var="today" value="${weatherForecast.get(0)}" />
				<h3>Today's Weather:</h3>
				<c:set var="imageName" value="${today.forecast}" />
				<c:if test="${imageName.equals('partly cloudy')}">
					<c:set var="imageName" value="partlyCloudy" />
				</c:if>
				<c:url var="weatherImgUrl" value="img/weather/${imageName}.png" />
				<img class="weatherImg" src="${weatherImgUrl}" alt="${imageName}" />
			 <p class="high">High: ${today.getHigh(tempPreference)} </p>
			<p class="low"> Low: ${today.getLow(tempPreference)} </p>
			
			<p class="weatherMessage"> ${today.message} </p>
			
			</div>
		
		<c:forEach begin="1" end="4" var="day">
		<div class="weekDayWeather">
			<c:set var="today" value="${weatherForecast.get(day)}" />
				<c:set var="imageName" value="${today.forecast}" />
				<c:if test="${imageName.equals('partly cloudy')}">
					<c:set var="imageName" value="partlyCloudy" />
				</c:if>
				<c:url var="weatherImgUrl" value="img/weather/${imageName}.png" />
				<img class="weatherImg" src="${weatherImgUrl}" alt="${imageName}" />
				
			 <p class="high">High: ${today.getHigh(tempPreference)} </p>
			<p class="low"> Low: ${today.getLow(tempPreference)} </p>
			</div>
		</c:forEach>
		</div>
			
		</div> 
	
</body>
</html>