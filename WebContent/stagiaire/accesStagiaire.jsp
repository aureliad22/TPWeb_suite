<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<link media="all" rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/basique/style.css" />
<title>TP Web</title>
</head>
<body>
	<div id="page">
		<div id="titre">
			<h1>TP Web - Accès Stagiaire</h1>
		</div>

		<%@include file="../menu.jspf"%>

		<div id="contenu">
		
		    <%
		        String messageErreur = (String)request.getAttribute("messageErreur");
		        if (messageErreur==null) messageErreur="";
		    %>
			<form class="connexion"	action="<%=request.getContextPath()%>/stagiaire/ValiderAccesStagiaire" method="post">
				<div class="bloc_identifiant">
					<label for="identifiant">Identifiant</label> 
					<input class="champtexte" type="text" id="identifiant" name="identifiant" />
				</div>
				<div class="bloc_motdepasse">
					<label for="motdepasse">Mot de passe</label> 
					<input class="champtexte" type="text" id="motdepasse" name="motdepasse" />
				</div>
				<div class="bloc_connexion">
					<input type="submit" id="seconnecter" value="Se connecter" />
				</div>
			</form>
			
        <% if (!"".equals(messageErreur)) { %>
        <div><p><%=messageErreur%></p></div>
        <% } %>
        
		</div>
	</div>
	<%@include file="/pieddepage.jspf"%>