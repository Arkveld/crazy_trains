<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Code HTML -->

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<link rel="stylesheet"  href="assets/css/style.css" type="text/css"/>
	</head>
	<body>
		<!-- Navigation -->
		<nav>
			<div> Logo </div>
			<span> &#9776; </span>
			
			<div>
				<a href="/projet_final/"> Acceuil </a> 
				<a href="/projet_final/articles">Articles</a>
				<c:choose>
					<c:when test="${sessionScope.user.role == 'user'}">
						<a href="/projet_final/profil"> Profil </a>
						<a href="/projet_final/logout"> Logout </a>
					</c:when>
					<c:when test="${sessionScope.user.role == 'admin'}">
						<a href="/projet_final/admin"> Administration </a>
						<a href="/projet_final/logout"> Logout </a>
					</c:when>
					<c:otherwise>
						<a href="/projet_final/login"> Login </a>
					</c:otherwise>
				</c:choose>
				<a href="#"> Contact </a>
			</div>
			
		</nav>
	
		<!-- Header -->
		<header>
			<h1> Mon application Web </h1>
		</header>
	
		<!-- Content  -->
		<jsp:invoke fragment="content"></jsp:invoke>
	
		<!-- Footer -->
		<footer>
			<p> My footer </p>
		</footer>
	
	</body>
</html>
