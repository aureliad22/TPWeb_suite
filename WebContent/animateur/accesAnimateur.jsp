<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
  <title>TP Web - Acces Animateur</title>
  <link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/basique/style.css" type="text/css"/>
</head>
<body>

<div id="page">

	<div id="entete">
		<h1>TP Web - Acces Animateur</h1>
	</div>

<%@ include file="/menu.jspf" %>

	<div id="contenu">
	
	<%
		String animateurId = request.getParameter("identifiant");
		if (animateurId==null) animateurId="";
		String animateurMdP = request.getParameter("motdepasse");
		if (animateurMdP==null) animateurMdP="";
		String messageErreur = (String)request.getAttribute("messageErreur");
		if (messageErreur==null) messageErreur="";
	%>
	
		<form class="connexion" action="<%=request.getContextPath()%>/animateur/ValiderAccesAnimateur" method="post">
		<div class="bloc_identifiant">
			<label for="identifiant">Identifiant</label>
			<input class="champtexte" type="text" id="identifiant" name="identifiant" value="<%=animateurId%>"/>
		</div>
		<div class="bloc_motdepasse">
			<label for="motdepasse">Mot de passe</label>
			<input class="champtexte" type="text"  id="motdepasse" name="motdepasse" value="<%=animateurMdP%>"/>
		</div>
		<div class="bloc_connexion">
			<input type="submit" id="seconnecter" value="Se connecter" />
		</div>
		</form>
		
		<% if (!"".equals(messageErreur)) { %>
		<div><p><%=messageErreur%></p></div>
		<% } %>

 	</div> 	
	
	<%@ include file="/pieddepage.jspf" %>
	
</div>
</body>
</html>
