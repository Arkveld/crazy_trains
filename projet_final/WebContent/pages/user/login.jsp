<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1> Page Login </h1>
	<form method="post" action="login">
		<div>
			<label for="mail"> Votre mail:</label>
			<input type="text" name="mail"/>
		</div>
		<div>
			<label for="password"> Votre password:</label>
			<input type="password" name="password"/>
		</div>
		<input type="submit" value="login"/>
	</form>
	<a href="/projet_final/"> Accueil </a>
</body>
</html>