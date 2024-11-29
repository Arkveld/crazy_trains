<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Espace commentaires</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Pseudo</th>
				<th>Contenu</th>
				<th>Date </th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${comments}" var="comment">
					<td><c:out value="${comment.pseudo}" /></td>
					<td><c:out value="${comment.contenu}" /></td>
					<td><c:out value="${comment.date}" /></td>
					<td><a href="/projet_final/deleteComment?id=${comment.id}">
							Supprimer</a></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<a href="/projet_final/admin"> retour administration </a>
</body>
</html>