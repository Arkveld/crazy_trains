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
	<form >
		<div>
			<label for="titre"> Votre titre </label>
			<input type="text"/>
		</div>
		<div>
			<label for="categorie"> Choisir la catégorie </label>
			<select>
				<c:forEach items="${categories}" var="categorie">
					<option value="${categorie.id}">
						<c:out value="${categorie.nom_categorie}"/>
					</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label for="contenuSql"> Votre Contenu 1 </label>
			<textarea rows="" cols=""></textarea>
		</div>
		<div>
			<label for="contenuNoSql"> Votre Contenu 2 </label>
			<textarea rows="" cols=""></textarea>
		</div>
		<div>
			<label for="titre"> Votre image </label>
			<input type="file"/>
		</div>
		<div>
			<label for="titre"> Date de publication </label>
			<input type="date"/>
		</div>
		<div>
			<input type="hidden" value="${sessionScope.user.id}"/>
		</div>
		<input type="submit" value="Pubilier">
	</form>
</body>
</html>