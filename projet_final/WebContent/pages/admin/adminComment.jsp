<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Espace commentaires">
	<jsp:attribute name="content">
		<h2>Gestion des commentaires </h2>
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
				<c:forEach items="${comments}" var="comment">
					<tr>
						<td><c:out value="${comment.pseudo}" /></td>
						<td><c:out value="${comment.contenu}" /></td>
						<td><c:out value="${comment.date}" /></td>
						<td><a href="/projet_final/deleteComment?id=${comment.id}"> Supprimer </a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</mt:template>



