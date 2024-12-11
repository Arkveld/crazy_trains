<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Profil">
	<jsp:attribute name="content">
		<h1> <c:out value="Bonjour ${sessionScope.user.nom}"/> </h1>
		<div class="profil">
			<a href="/projet_final/updateProfil?id=${sessionScope.user.id}"> Modifier votre profil</a>
			<a href="/projet_final/publish"> Publier un article</a>
			<a href="/projet_final/logout"> Se déconnecter </a>
		</div>
	</jsp:attribute>
</mt:template>

