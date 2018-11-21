<%@page import="fr.ngando.person.domain.Person"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">

</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<c:if test="${sessionScope.isConnected}">
		<c:redirect url="account" />
	</c:if>
	<c:if test="${(connexionFail != null)&&(connexionFail)}">
		<p class="text-center error connexionMsg">
			:( Erreur lors de la connexion !<br>
			Vérifie ton login et ton mot de passe stp !<br>
		</p>
	</c:if>
	<section>
		<fieldset class="loginFielset">
			<legend>Vos identifiants :</legend>
			<form id="login" action="login" class="div80" method="post">
				<div class="input-block">
					<input name="login" type="text" placeholder="Login" />
					<p class="error"></p>
				</div>
				<div class="input-block">
					<input name="password" type="password" placeholder="password">
					<p class="error"></p>
				</div>
				<button type="submit" onclick="return valideLoginForm()">Valider</button>
			</form>
		</fieldset>
		<p class="text-center">		
			Pas encore de compte ? <br>
			<a href="register" class="underline">Inscris-toi ici !</a>
		</p>
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
</body>
</html>