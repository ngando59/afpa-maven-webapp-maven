<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<c:if test="${!sessionScope.uGrant.equals('full')}">
		<c:redirect url="login" />
	</c:if>
	<section class="container">
		<div class="tab">
  			<button class="tablinks active" onclick="openCity(event, 'products')">Produits</button>
  			<button class="tablinks" onclick="openCity(event, 'users')">Utilisateurs</button>
		</div>
		
		<div id="products" class="tabcontent" style="display: block;">
			<h1>Produits</h1>
			<a  href="add-product" class="btn-add"><i class="fas fa-plus"></i>ajouter un produit</a>
			<section class="adminPanel">
			 <div class="items">
                <c:forEach items="${products}" var="product">
    				<div class="item">
                    <a href="product?ref=${product.id}">
                        <img src="resources/img/${product.thumbnail}" alt="">
                        <h3>${product.title}</h3>
                    </a>
                </div>
				</c:forEach>
            </div> 
		</section>
		</div>

		<div id="users" class="tabcontent">
		  <h3>Utilisateurs</h3>
		  <a href="add-user" class="btn-add"><i class="fas fa-plus"></i>ajouter un utilisateur</a>
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
		</div>
		
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
	<script type="text/javascript" src="resources/js/admin.js"></script>
</div>
</body>
</html>