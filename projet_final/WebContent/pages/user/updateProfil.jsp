<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Modifier profil</title>
</head>
<body>
	<p> Modifier votre profil </p>
	<form method="post" action="updateProfil">
		<div>
			<label for="nom"> Nom </label> <input type="text" name="nom"
				pattern="[a-zA-Z]{1,32}" required="required" value="${user.nom}">
				<p>${messageError != null ? messageError : "" } </p>
		</div>
		<div>
			<label for="prenom"> Prénom </label> <input type="text" name="prenom"
				pattern="[a-zA-Z]{1,32}" required="required" value="${user.prenom}">
				<p>${messageError != null ? messageError : "" } </p>
		</div>
		<div>
			<label for="mail"> Mail </label> <input type="email" name="mail"
				required="required" value="${user.email}">
				<p>${messageError != null ? messageError : "" } </p>
		</div>
		<div>
			<label for="question"> Choisir une question </label>
			<select name="question">
				<c:forEach items="${questions}" var="question">
					<option value="${question.id}"> <c:out value="${question.question}"/> </option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label for="reponse"> Votre réponse </label> <input type="text"
				name="reponse">
		</div>
		<input type="hidden" name="id" value="${sessionScope.user.id}" /> 
		<input type="submit" value="Valider" />
	</form>
</body>
</html>