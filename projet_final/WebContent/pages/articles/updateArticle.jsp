<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:template title="Modifier un article">
	<jsp:attribute name="content">
		<h2> Modifier un article</h2>
		<form method="post" action="update" enctype="multipart/form-data">
			<div>
				<label for="titre"> Votre titre </label>
				<input type="text" name="titre" value="${article.titre}"/>
			</div>
			<div>
				<label for="categorie"> Choisir la catégorie </label>
				<select name="categorie">
					<c:forEach items="${categories}" var="categorie">
						<option value="${categorie.id}">
							<c:out value="${categorie.nom_categorie}"/>
						</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label for="contenu"> Votre Contenu </label>
				<textarea rows="4" cols="50" name="contenu" >
					${article.contenu}
				</textarea>
			</div>
			<div>
				<label for="image"> Votre image </label>
				<input type="file" name="image"/>
			</div>
			<div>
				<label for="legende"> Titre de l'image</label>
				<input type="text" name="legende" value="${article.legende}">
			</div>
			<div>
				<label for="date"> Date de publication </label>
				<input type="date" name="date"/>
			</div>
			<div>
				<input type="hidden" value="${sessionScope.user.id}" name="auteur"/>
				<input type="hidden" value="${article.id}" name="id"/>
			</div>
			<input type="submit" value="Modifier">
		</form>
	</jsp:attribute>
</mt:template>


