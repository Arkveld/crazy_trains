<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Se connecter">
	<jsp:attribute name="content">
		<h2>Veuillez vous connecter</h2>
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
			<p>${messageError != null ? messageError : "" } </p>
		</form>
		<p style="text-align:center;"> Pas encore inscrit alors <a href="/projet_final/register" style="text-decoration:underline; color: white">Clique-ici </a></p>
		
	</jsp:attribute>
</mt:template>


