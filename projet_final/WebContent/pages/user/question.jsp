<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Authentification">
	<jsp:attribute name="content">
		<h1> Par mesure de sécurité on veut être sur que c'est bien vous. Veuillez répondre à la question </h1>
		<form method="post" action="authentification">
			<label for="question">
				<c:out value="${question.question}"/>
			</label>
			<input type="text" name="reponse"/>
			<input type="hidden" value="${user.email}" name="mail"/>
			<input type="submit" value="Valider"/>
	</form>
	</jsp:attribute>
</mt:template>

