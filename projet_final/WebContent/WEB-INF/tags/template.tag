<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Code HTML -->

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<link
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="assets/css/style.css" />
	</head>
	<body>
	 	<nav>
      		<div style="padding: 10px">
        		<span class="material-symbols-outlined" id="burger" onclick="toggler()">
          		menu
        		</span>
      		</div>
      		<div class="menu">
        		<div class="logo">
          			<a href="#">
            			<img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="logo du site" />
          			</a>
        		</div>
        		<ul>
          			<li><a href="#">Acceuil</a></li>
          			<li><a href="#">Catégories</a></li>
          			<li>
          				<c:choose>
							<c:when test="${sessionScope.user.role == 'user'}">
								<a href="/projet_final/profil"> Profil </a>
								<a href="/projet_final/logout"> Logout </a>
							</c:when>
							<c:when test="${sessionScope.user.role == 'admin'}">
								<a href="/projet_final/admin"> Administration </a>
								<a href="/projet_final/logout"> Logout </a>
							</c:when>
							<c:otherwise>
								<a href="/projet_final/login"> Login </a>
							</c:otherwise>
						</c:choose>
          			</li>
          			<li><a href="#">Contact</a></li>
        		</ul>
      		</div>
    	</nav>
    	<header>
      	<h1>Crazy trains</h1>
    	</header>
    	<!-- Content  -->
		<jsp:invoke fragment="content"></jsp:invoke>
	
		<!-- Footer -->
		<footer>
      		<div>
        		<p>Réseau sociaux</p>
      		</div>
      		<nav>
        		<a href="#"> Accueil</a>
        		<a href="#"> Mentions légales </a>
        		<a href="#"> Contact </a>
     		</nav>
   		</footer>
	
		<script type="text/javascript" src="assets/js/app.js"></script>
	</body>
</html>

<!-- 
<img alt="logo du site" src="${pageContext.request.contextPath}/assets/images/logo.png"/>	
<a href="#" class="logo"> <img alt="logo du site" src="${pageContext.request.contextPath}/assets/images/logo.png"/>
				</a>

<c:choose>
					<c:when test="${sessionScope.user.role == 'user'}">
						<a href="/projet_final/profil"> Profil </a>
						<a href="/projet_final/logout"> Logout </a>
					</c:when>
					<c:when test="${sessionScope.user.role == 'admin'}">
						<a href="/projet_final/admin"> Administration </a>
						<a href="/projet_final/logout"> Logout </a>
					</c:when>
					<c:otherwise>
						<a href="/projet_final/login"> Login </a>
					</c:otherwise>
				</c:choose> -->
