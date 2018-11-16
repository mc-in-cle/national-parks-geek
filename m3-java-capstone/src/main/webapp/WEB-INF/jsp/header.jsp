<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/site.css" />

<!DOCTYPE html>
<html>
	<head>
		<title>${pageTitle }</title>
	    <c:url value="/css/site.css" var="cssHref" />
	    <link rel="stylesheet" href="${cssHref}">
	</head>
	<header>
		<c:url value="/" var="homePageURL"/>
		<c:url value="/img/logo.png" var="logoSrc"/>
		<a href="${homePageURL }">
			<img src="${logoSrc }" alt="National Parks Geek logo" />
		</a>
	</header>
	<nav>
		<div id="main-nav">
			<ul>
				<li><a href="${homePageURL }">Home</a></li>
				<li><a href="survey">Survey</a></li>
			</ul>
		</div>
		<div id="temperature-buttons">
			<ul>
				<c:url value="/toggleTemp" var="tempURL"/>
				<li><a href="${tempURL }?format=C">&#176;C</a></li>
				<li><a href="${tempURL }?format=F">&#176;F</a></li>
			</ul>
				<p>Temperature Preference:</p>
		</div>
	</nav>
	