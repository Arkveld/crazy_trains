<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Commentaire</title>
</head>
<body>
	<p> Page commentaire </p>
	<form>
		<div>
			<label for="pseudo"> Votre pseudo </label>
			<input type="text" name="pseudo"/>
		</div>
		<div>
			<label for="contenu"> Votre commentaire </label>
			<input type="text" name="contenu"/>
		</div>
		<div>
			<label for="date"> Date </label>
			<input type="date" name="date"/>
		</div>
		<input type="hidden" value="${id}" name="article"/>
		<input type="submit" value="Valider" />
	</form>
</body>
</html>