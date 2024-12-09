<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Gestion des utilisateurs">
	<jsp:attribute name="content">
		<h2>Gestion des utilisateurs </h2>	
		<table>
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th> Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.nom}" /></td>
						<td><c:out value="${user.prenom}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td> <a href="/projet_final/deleteProfil?id=${user.id}">
								Supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</mt:template>



<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Espace utilisateurs</title>
</head>
<body>
	<h1>Page administration</h1>
	<a href="/projet_final/"> Accueil </a>
	<a href="/projet_final/logout"> Logout </a>
	<p> Page de gestion des utilisateurs </p>
	
	<table>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th> Email</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${users}" var="user">
					<td><c:out value="${user.nom}" /></td>
					<td><c:out value="${user.prenom}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td> <a href="/projet_final/deleteProfil?id=${user.id}">
							Supprimer</a></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<a href="/projet_final/admin"> retour administration </a>
</body>
</html>-->