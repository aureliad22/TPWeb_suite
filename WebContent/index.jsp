<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<link  media="all" rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/basique/style.css" /> 
	<title>TP Web - Accueil</title>
</head>
<body>

<div id="page">

	<div id="entete">
		<h1>TP Web - Accueil</h1>
	</div>

	<%@ include file="/menu.jspf" %>

	<div id="contenu">
		<p>Bienvenue sur TP Web !</p>
		<p>Accédez à toutes les fonctionnalités qui vous sont autorisées en vous rendant sur votre rubrique d'accès (animateur ou stagiaire)</p>
		<p>Pour faire une recherche sur Google, utilisez le formulaire de recherche.</p>	
    </div>
		
	<%@ include file="/pieddepage.jspf" %>

</div>

</body>
</html>
