<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Home </title>
</head>
<body>
	<h1> Page d'accueil </h1>
	<a href="/projet_final/register"> S'inscrire</a>
	<c:choose>
		<c:when test="${sessionScope.user != null}">
			<a href="/projet_final/profil"> Profil </a>
			<a href="/projet_final/logout"> Logout </a>
		</c:when>
		<c:otherwise>  
			<a href="/projet_final/login"> Login </a>
		</c:otherwise>
	</c:choose>
</body>
</html>