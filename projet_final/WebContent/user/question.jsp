<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
</head>
<body>
	<h1> 
		Par mesure de sécurité on veut être sur que c'est bien vous.
		Veuillez répondre à la question
	</h1>
	<form>
		<label for="question">
			<c:out value="${user.mail}"/>
		</label>
		<input type="text" name="reponse"/>
	</form>
	
</body>
</html>