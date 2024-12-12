<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="${article.titre}">
	<jsp:attribute name="content">
		<ul class="breadcump">
			<li><a href="/projet_final/">Home</a></li>
			<li><a href="/projet_final/articles"> Articles</a></li>
			<li> ${article.titre}</li>
		</ul>
		
		<main>
			<article class="single">
				<h2> <c:out value="${article.titre}"/> </h2>
				<h4> Publié le <c:out value="${article.date}"/></h4>
				<figure>
					<img alt="" src="assets/images/${article.imageUrl}">
					<figcaption> <c:out value="${article.legende}"/> </figcaption>
				</figure>
				<p> <c:out value="${article.contenu}"/></p>
				<p> <c:out value="${article.contenu}"/></p>
			</article>
		</main>
		
		<h2> Commentaires </h2>
		<div>
			<c:choose>
				<c:when test="${commentaires != null}">
					<c:forEach items="${commentaires}" var="commentaire">
						<h4> <c:out value="${commentaire.pseudo}"/> </h4>
						<p> <c:out value="${commentaire.contenu}"/> </p>
						<small> <c:out value=" Posté le ${commentaire.date}"/></small>
					</c:forEach>
				</c:when>
				<c:otherwise> 
					<p> Soyer le premier à ajouter à un commentaire </p>
				</c:otherwise>
			</c:choose>
		</div>
		<a href="/projet_final/commentaire?id=${article.id}" style="color: whitesmoke; text-decoration: underline;"> Ajouter un commentaire</a>
	</jsp:attribute>
</mt:template>


