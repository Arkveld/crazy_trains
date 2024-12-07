<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Espace article">
	<jsp:attribute name="content">
		<h2>Gestion des articles </h2>
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
		<a href="/projet_final/admin"> retour administration </a>
	</jsp:attribute>
</mt:template>


