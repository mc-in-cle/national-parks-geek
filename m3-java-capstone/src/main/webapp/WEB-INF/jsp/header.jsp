<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<ul>
			<li><a href="${homePageURL }">Home</a></li>
			<li><a href="survey">Survey</a></li>
		</ul>
	</nav>
	