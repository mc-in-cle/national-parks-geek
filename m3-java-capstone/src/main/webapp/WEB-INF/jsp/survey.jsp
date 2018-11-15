<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="pageTitle" value="National Parks Geek" />
</c:import>

<body>
	<h2>Participate in the Survey</h2>
	<form action="survey" method="POST">
	<div class="formItem">
	<label for="parkName">Vote for your favorite park:</label>
	<select id="parkName" name="parkName">
		<option value="cvnp">Cuyahoga Valley National Park</option>
		<option value="enp">Everglades National Park</option>
		<option value="gcnp">Grand Canyon National Park</option>
		<option value="gnp">Glacier National Park</option>
		<option value="gsmnp">Great Smoky Mountains National Park</option>
		<option value="gtnp">Grand Teton National Park</option>
		<option value="mrnp">Mount Rainier National Park</option>
		<option value="rmnp">Rocky Mountain National Park</option>
		<option value="ynp">Yellowstone National Park</option>
		<option value="ynp2">Yosemite National Park</option>
	</select>
	</div>
		<div class="formItem">
			<label for="email">Your email:</label> <input type="text" name="email"
				id="email" />
		</div>
		<div class="formItem">
			<label for="state">Your state of residence:</label>
			<select id="state" name="state">
			<c:forEach var="s" items="${usStates }">
				<option value=${s }>${s }</option>
			</c:forEach>
			</select>
		</div>
		<div class="formItem">
			<label for="activityLevel">Your activity level:</label>
			<select id="activityLevel" name="activityLevel">
				<option value="Extremely Active">Extremely Active</option>
				<option value="Active">Active</option>
				<option value="Inactive">Inactive</option>
				<option value="Sedentary">Sedentary</option>
			</select>
		</div>
		</form>
</body>
</html>