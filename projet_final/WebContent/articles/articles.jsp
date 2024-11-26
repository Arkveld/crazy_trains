<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Articles </title>
</head>
<body>
	<h1> Page Articles </h1>
	<c:forEach items="${articles}" var="article">
		<article>
			<h2> <c:out value="${article.titre}"/></h2>
			<p> <c:out value="${article.contenu}"/> </p>
			<a href="${article.id}"> voir plus </a>
		</article>
	</c:forEach>
</body>
</html>