<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Profil </title>
</head>
<body>
	<h1>
		<c:out value="Bonjour ${sessionScope.user.nom}"/>
	</h1>
	<a href="/projet_final/"> Accueil</a>
	<a href="/projet_final/updateProfil"> Modifier votre profil</a>
	<a href="/projet_final/publish"> Publier un article</a>
	<a href="/projet_final/logout"> Se déconnecter </a>
</body>
</html>