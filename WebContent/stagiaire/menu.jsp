<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
<title>TP Web - Menu stagiaire</title>
<link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/basique/style.css" type="text/css"/>
</head>
<body>
<div id="page">

	<div id="entete">
		<h1>TP Web - Menu Stagiaire</h1>
	</div>

	<%@ include file="/stagiaire/navigation.jspf" %>

	<div id="contenu">

		<p>
			Bonjour ${stagiaireConnecte.prenom} ${stagiaireConnecte.nom}
		</p>
	</div>
	
	<%@ include file="/pieddepage.jspf" %>
		
</div>

</body>
</html>