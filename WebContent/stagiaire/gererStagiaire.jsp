<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import ="fr.eni_ecole.jee.bean.*, java.util.*"
%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
  <title>TP Web - Gestion du profil Stagiaire</title>
  <link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/basique/style.css" type="text/css"/>
</head>
<body>
<div id="page">

    <div id="entete">
        <h1>TP Web - Gestion du profil Stagiaire</h1>
    </div>

<%@ include file="/stagiaire/navigation.jspf" %>

    <div id="contenu">

    <%@ include file="/stagiaire/gestionStagiaire.jspf" %>
    
    </div>
    
    <%@ include file="/pieddepage.jspf" %>
    
    </div>
</body>
</html>