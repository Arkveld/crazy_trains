<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription </title>
</head>
<body>
	<h1> Page d'inscription </h1>
	
	<h2> Question </h2>
	
	<c:forEach items="${questions}" var="question">
		<p> <c:out value="${question.question}"/></p>
	</c:forEach>
	
    <h2> Formulaire d'inscription </h2>
    <form method="post" action="">
    	<div>
    		<label for="nom"> Nom </label>
    		<input type="text" name="nom" pattern="[a-zA-Z]{1,32}" required="required">
    	</div>
    	<div>
    		<label for="prenom"> Prénom </label>
    		<input type="text" name="prenom" pattern="[a-zA-Z]{1,32}" required="required">
    	</div>
    	<div>
    		<label for="mail"> Mail </label>
    		<input type="email" name="mail" required="required">
    	</div>
    	<div>
    		<label for="password"> Mot de passe </label>
    		<input type="password" name="password">
    	</div>
    	<input type="hidden" name="role" value="user"/>
    	
    	<input type="submit" value="Valider" />
    </form>
    <a href="/projet_final/"> Retour à l'accueil</a>
</body>
</html>