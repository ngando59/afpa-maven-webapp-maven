<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<section class="container contact">
		<h1>Contact</h1>
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2527.442191619956!2d3.156409915740184!3d50.69317827950956!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47c328e2f9dd32f5%3A0x3b33b05842792807!2sCentre+de+formation+Afpa+Roubaix!5e0!3m2!1sfr!2sfr!4v1539868131849" frameborder="0" style="border:0" allowfullscreen></iframe>
		<div class="container-flex">
			<div class="div50">
				<h4>Nous contacter</h4>
				<form id="contact" name="contact" method="post">
					<div class="input-block">
						<input type="text" name="nom" placeholder="Nom (*)" required>
						<p class="error"></p>
					</div>
					<div class="input-block">
						<input type="email" name="email" placeholder="Email (*)" required>
						<p class="error"></p>
					</div>
					<div class="input-block">
						<input type="text" name="objet" placeholder="Objet (*)" required>
						<p class="error"></p>
					</div>
					<div class="input-block">
						<textarea name="message" required rows="5"></textarea>
						<p class="error"></p>
					</div>
					<button class="right" type="button" onclick="valideContactForm()">Envoyer</button>
				</form>
			</div>
			<div class="div50">
				<h4>WebApp</h4>
				<i class="fas fa-map-marker"></i><span>Centre de formation Afpa Lille Lomme</span><br>	
				<span>20 Rue du Luxembourg, 59100 Roubaix</span><br><br>
				<i class="fas fa-phone-volume"></i><span>03 03 03 03 03</span><br><br>
				<i class="fas fa-mail-bulk"></i>webapp@mail.fr<br>
			</div>
		</div>
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
<script type="text/javascript" src="resources/js/contact.js"></script>
</body>
</html>