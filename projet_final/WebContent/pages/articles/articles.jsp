<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Articles">
	<jsp:attribute name="content">
		<h1> Page Articles </h1>
		<c:forEach items="${articles}" var="article">
			<article>
				<h2> <c:out value="${article.titre}"/></h2>
				<p> <c:out value="${article.contenu}"/> </p>
				<a href="/projet_final/single?id=${article.id}"> voir plus </a>
			</article>
		</c:forEach>
	</jsp:attribute>
</mt:template>


