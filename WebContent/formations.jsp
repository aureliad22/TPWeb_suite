<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
			<h1>TP Web - Liste de formations</h1>
		</div>
		
		<%@include file="/menu.jspf"%>
		
		<div id="contenu">
			<div class="formation">
				<c:forEach items="${formations}" var="formation">
				<div class="formationIndiv">
					<h2>
						&nbsp;${formation.libelle}
					</h2>
					<p>
					   ${formation.description}
					</p>
					<ul>
						<li>Date de début : <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${formation.dateDebut}"/></li>
						<li>Date de fin : <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${formation.dateFin}"/></li>
					</ul>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@include file="/pieddepage.jspf"%>