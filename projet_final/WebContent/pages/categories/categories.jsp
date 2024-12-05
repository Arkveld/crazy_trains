<!-- Import du template -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Catégories">
	<jsp:attribute name="content">
		<ul class="breadcump">
			<li><a href="/projet_final/">Home</a></li>
			<li> Catégories</li>
		</ul>
		<div class="categories">
			<div class="trains" style="background-image: url('assets/images/trains.jpg');">
				<a href="/projet_final/trains"> Trains </a>
			</div>
			<div class="trams" style="background-image: url('assets/images/trams.jpg');">
				<a href="/projet_final/tramways"> Tramways </a>
			</div>
		</div>
	</jsp:attribute>
</mt:template>



<!-- 
<c:forEach items="${categories}" var="categorie">
				<a href="/projet_final/${categorie.nom_categorie.toLowerCase()}"> <c:out value="${categorie.nom_categorie}"/> </a>
			</c:forEach>

 -->