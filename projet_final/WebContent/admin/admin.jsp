<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration</title>
</head>
<body>
	<h1>Page administration</h1>
	<a href="/projet_final/"> Accueil </a>
	<a href="/projet_final/logout"> Logout </a>

	<table>
		<thead>
			<tr>
				<th>Titre</th>
				<th>contenu</th>
				<th>Date de publication</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${articles}" var="article">
					<td><c:out value="${article.titre}" /></td>
					<td><c:out value="${article.contenu}" /></td>
					<td><c:out value="${article.date}" /></td>
					<td><a href="/projet_final/update?id=${article.id}">
							Modifier</a> <a href="/projet_final/delete?id=${article.id}">
							Supprimer</a></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>