<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
    import="java.util.List, fr.eni_ecole.jee.bean.Formation, fr.eni_ecole.tools.ManipDate"%>

<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<link media="all" rel="stylesheet" type="text/css"
    href="<%=request.getContextPath()%>/theme/basique/style.css" />
<title>TP Web</title>
</head>
<body>
    <div id="page">
        <div id="titre">
            <h1>TP Web - Liste de formations</h1>
        </div>
        <%@include file="/menu.jspf"%>
        <div id="contenu">
	        <form class="connexion" action="">
	        <div class="bloc_identifiant">
	            <label for="identifiant">Identifiant</label>
	            <input class="champtexte" type="text" id="identifiant" name="identifiant" />
	        </div>
	        <div class="bloc_motdepasse">
	            <label for="motdepasse">Mot de passe</label>
	            <input class="champtexte" type="text"  id="motdepasse" name="motdepasse" />
	        </div>
	        <div class="bloc_connexion">
	            <input type="submit" id="seconnecter" value="se connecter" />
	        </div>
	        </form>              
        </div>
    </div>
<%@include file="/pieddepage.jspf"%>