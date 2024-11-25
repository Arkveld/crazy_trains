<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Publication</title>
</head>
<body>
	<h1> Ajouter un article</h1>
	<form method="post" action="publish" enctype="multipart/form-data">
		<div>
			<label for="titre"> Votre titre </label>
			<input type="text" name="title"/>
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
			<label for="contenu1"> Votre Contenu 1 </label>
			<textarea rows="4" cols="50" name="contenu1"></textarea>
		</div>
		<div>
			<label for="titre"> Votre image </label>
			<input type="file" name="image"/>
		</div>
		<div>
			<label for="legende"> Titre de l'image</label>
			<input type="text" name="legende">
		</div>
		<div>
			<label for="titre"> Date de publication </label>
			<input type="date" name="date"/>
		</div>
		<div>
			<input type="hidden" value="${sessionScope.user.id}" name="auteur"/>
		</div>
		<input type="submit" value="Pubilier">
	</form>
</body>
</html>