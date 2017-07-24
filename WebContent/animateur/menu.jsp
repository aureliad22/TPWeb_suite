<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
<title>TP Web - Menu animateur</title>
<link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/basique/style.css" type="text/css"/>
</head>
<body>
<div id="page">

	<div id="entete">
		<h1>TP Web - Menu Animateur</h1>
	</div>

	<%@ include file="/animateur/menu.jspf" %>

	<div id="contenu">
	<jsp:useBean id="animateurConnecte" class="fr.eni_ecole.jee.bean.Animateur" scope="session" />
	<p>
	Bonjour
	<jsp:getProperty property="prenom" name="animateurConnecte"/>
	<jsp:getProperty property="nom" name="animateurConnecte"/>	
	</p>
	</div>
	
	<%@ include file="/pieddepage.jspf" %>
		
</div>

</body>
</html>