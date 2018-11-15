<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="pageTitle" value="National Parks Geek" />
</c:import>

<body>

	<form action="spaceForum" method="POST">
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
		<div class="email">
			<label for="email"> Email: </label> <input type="text" name="email"
				id="email" />
		</div>
		</form>
</body>
</html>