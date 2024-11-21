<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Profil </title>
</head>
<body>
	<h1>
		<c:out value="Bonjour ${sessionScope.prenom}"/>
	</h1>
	<a href="/projet_final/logout"> Se déconnecter </a>
</body>
</html>