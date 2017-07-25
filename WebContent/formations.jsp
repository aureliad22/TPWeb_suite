<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<div class="formation">
				<%
					List<Formation> listeFormations = (List<Formation>) request.getAttribute("formations");
					for (Formation f : listeFormations) {
				%>
				<div class="formationIndiv">
					<h2>
						&nbsp;<%=f.getLibelle()%></h2>
					<p><%=f.getDescription()%></p>
					<ul>
						<li>Date de début : <%=ManipDate.dateAuFormatLong(f.getDateDebut())%></li>
						<li>Date de fin : <%=ManipDate.dateAuFormatLong(f.getDateFin())%></li>
					</ul>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<%@include file="/pieddepage.jspf"%>