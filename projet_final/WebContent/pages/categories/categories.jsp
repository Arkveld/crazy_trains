<!-- Import du template -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Catégories">
	<jsp:attribute name="content">
	
		<h2> Catégories </h2>
		<section class="categories">
			<div class="trains" style="background-image: url('assets/images/trains.jpg');">
				<a href="/projet_final/trains"> Trains </a>
			</div>
			<div class="trams" style="background-image: url('assets/images/trams.jpg');">
				<a href="/projet_final/tramways"> Tramways </a>
			</div>
		</section>
	</jsp:attribute>
</mt:template>



<!-- 
<c:forEach items="${categories}" var="categorie">
				<a href="/projet_final/${categorie.nom_categorie.toLowerCase()}"> <c:out value="${categorie.nom_categorie}"/> </a>
			</c:forEach>

 -->