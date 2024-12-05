<!-- Import du template -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Catégories">
	<jsp:attribute name="content">
		<h1> Page catégories </h1>
		<section>
			<c:forEach items="${categories}" var="categorie">
				<a href="/projet_final/${categorie.nom_categorie.toLowerCase()}"> <c:out value="${categorie.nom_categorie}"/> </a>
			</c:forEach>
		</section>
	</jsp:attribute>
</mt:template>