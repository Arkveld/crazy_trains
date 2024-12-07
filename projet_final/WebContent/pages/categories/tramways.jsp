<!-- Import du template -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Tramways">
	<jsp:attribute name="content">
		<ul class="breadcump">
			<li><a href="/projet_final/">Home</a></li>
			<li>Trains</li>
		</ul>
		<div class="list">
			<c:forEach items="${articles}" var="article">
				<article>
					<h2> <c:out value="${article.titre}"/></h2>
					<p> <c:out value="${article.contenu.substring(0, 600)}"/>...</p>
					<a href="/projet_final/single?id=${article.id}"> Voir plus </a>
				</article>
			</c:forEach>
		</div>
	</jsp:attribute>
</mt:template>