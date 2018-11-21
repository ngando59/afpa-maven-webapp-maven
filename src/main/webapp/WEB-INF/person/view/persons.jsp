<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utilisateurs</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<section class="container have2Side">
		<h1>Utilisateurs</h1>
		<ul class="divUsers">
			<c:forEach items="${persons}" var="person" varStatus="status">
				<li>
					<a href="user?id=${status.count}">
						<c:if test="${person.civilite.equals('Mrs')}" >
							<img alt="" src="resources/img/male.png">
						</c:if>
						<c:if test="${person.civilite.equals('Mme')}" >
							<img alt="" src="resources/img/female.png">
						</c:if>
						<p class="text-center">
							${person.nom } ${person.prenom }
						</p>
					</a>
				</li>
			</c:forEach>
		</ul>
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
</body>
</html>