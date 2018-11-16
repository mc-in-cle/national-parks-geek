<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="header.jsp">
	<c:param name="pageTitle" value="National Parks Geek" />
</c:import>

<body>
	<h2>Participate in the Survey</h2>
	<form:form action="survey" method="POST" modelAttribute="survey">
		<div class="formItem">
			<label for="parkCode">Vote for your favorite park:</label>
			<select id="parkCode" name="parkCode">
				<c:forEach var="park" items="${parksList }">
					<option value="${park.parkCode }">${park.parkName }</option>
				</c:forEach>
			</select>
			<form:errors path="parkCode" cssClass="error"/>
		</div>
		<div class="formItem">
			<label for="email">Your email:</label> <input type="text"
				name="email" id="email" />
			<form:errors path="email" cssClass="error" />
			
		</div>
		<div class="formItem">
			<label for="state">Your state of residence:</label> <select
				id="state" name="state">
				<c:forEach var="s" items="${usStates }">
					<option value=${s }>${s }</option>
				</c:forEach>
			</select>
			<form:errors path="state" cssClass="state"/>
		</div>
		<div class="formItem">
			<label for="activityLevel">Your activity level:</label> 
			<input type="radio" name="activityLevel" value="Extremely Active">Extremely Active
			<input type="radio" name="activityLevel" value="Active">Active
			<input type="radio" name="activityLevel" value="Inactive">Inactive
			<input type="radio" name="activityLevel" value="Sedentary">Sedentary
			<form:errors path="activityLevel" cssClass="activityLevel"/>
		</div>
		<div class="formItem">
			<input type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>