<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Single</title>
</head>
<body>
	<h1> Page single</h1>
	<h2> 
		<c:out value="Titre: ${article.titre}"/>
	</h2>
	<p> <c:out value="legende: ${article.legende}"/>
	
</body>
</html>