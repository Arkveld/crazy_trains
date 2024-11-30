<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Inscription">
	<jsp:attribute name="content">
		<h2>Formulaire d'inscription</h2>
		<form method="post" action="register">
			<div>
				<label for="nom"> Nom </label> <input type="text" name="nom"
				pattern="[a-zA-Z]{1,32}" required="required">
					<p>${messageError != null ? messageError : "" } </p>
			</div>
			<div>
				<label for="prenom"> Prénom </label> <input type="text" name="prenom"
				pattern="[a-zA-Z]{1,32}" required="required">
					<p>${messageError != null ? messageError : "" } </p>
			</div>
			<div>
				<label for="mail"> Mail </label> <input type="email" name="mail"
				required="required">
					<p>${messageError != null ? messageError : "" } </p>
			</div>
			<div>
				<label for="password"> Mot de passe </label> <input type="password"
				name="password">
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
				<label for="reponse"> Votre réponse </label> 
					<input type="text" name="reponse">
			</div>
			<input type="hidden" name="role" value="user" /> 
			<input type="submit" value="Valider" />
		</form>
		<a href="/projet_final/"> Retour à l'accueil</a>
	</jsp:attribute>
</mt:template>

	<!-- <h1>Page d'inscription</h1>
	<h2>Formulaire d'inscription</h2>
	<form method="post" action="register">
		<div>
			<label for="nom"> Nom </label> <input type="text" name="nom"
				pattern="[a-zA-Z]{1,32}" required="required">
				<p>${messageError != null ? messageError : "" } </p>
		</div>
		<div>
			<label for="prenom"> Prénom </label> <input type="text" name="prenom"
				pattern="[a-zA-Z]{1,32}" required="required">
				<p>${messageError != null ? messageError : "" } </p>
		</div>
		<div>
			<label for="mail"> Mail </label> <input type="email" name="mail"
				required="required">
				<p>${messageError != null ? messageError : "" } </p>
		</div>
		<div>
			<label for="password"> Mot de passe </label> <input type="password"
				name="password">
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
		<input type="hidden" name="role" value="user" /> <input type="submit"
			value="Valider" />
	</form>
	<a href="/projet_final/"> Retour à l'accueil</a> -->
