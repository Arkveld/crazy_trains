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
	<form method="post" action="authentification">
		<label for="question">
			<c:out value="${question.question}"/>
		</label>
		<input type="text" name="reponse"/>
		<input type="hidden" value="${user.email}" name="mail"/>
		
		
		<input type="submit" value="Valider"/>
	</form>
	
</body>
</html>