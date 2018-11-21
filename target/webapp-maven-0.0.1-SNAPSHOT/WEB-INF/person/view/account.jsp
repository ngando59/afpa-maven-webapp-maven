<%@page import="fr.ngando.person.domain.Person"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<script type="text/javascript">
function logout() {
	var txt;
	var r = confirm("Tu veux vraiment te déconnecter ?");
	if (r == true) {
		document.location.href="logout"
	} 
}
</script>
</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<c:choose>
		<c:when test="${person != null}">
			<h1>Mon compte</h1>
			<div class="text-right padding15">
				<button onclick="logout()"><i class="fas fa-sign-out-alt"></i>Deconnexion</button>
			</div>
			<section class="user-infos">
				<div class="div-ico-user">
					<c:if test="${person.civilite.equals('Mrs')}" >
						<img class="ico-user" alt="" src="resources/img/male.png">
					</c:if>
					<c:if test="${person.civilite.equals('Mme')}" >
						<img class="ico-user" alt="" src="resources/img/female.png">
					</c:if>
				</div>
				<div>
					<fieldset class="infos-perso">
						<legend>Informations personelles</legend>
						<i class="fas fa-user"></i><span>${person.civilite}
						${person.nom} ${person.prenom}</span><br> 
						<i class="fas fa-birthday-cake"></i><span>${person.dateNaissance}</span><br> 
						<i class="fas fa-at"></i><span>${person.email}</span><br> 
						<i class="fas fa-mobile-alt"></i><span>${person.telephone}</span><br>
					</fieldset>
					<fieldset class="infos-perso">
						<legend>Adresse</legend>
						<div class="text-right">
							<i class="fas fa-map-marker"></i><span>${person.numeroEtRue}</span><br>
							<span>${person.ville}, ${person.departement}</span><br>
							<span>${person.pays}</span>
						</div>
					</fieldset>
					<c:if test="${sessionScope.uGrant.equals('full')}">
						<fieldset class="infos-perso">
							<legend>Role</legend>
							<p>Administrateur</p>
						</fieldset>
					</c:if>		
				</div> 					
			</section>
		</c:when>
		<c:otherwise>
			<c:redirect url="login" />
		</c:otherwise>
	</c:choose>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
</body>
</html>