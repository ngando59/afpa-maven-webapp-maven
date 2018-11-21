
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mise à jour produits</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<section class="container">
	   <h1>Mise à jour produit</h1>
	   <div>
	   		<form id="updateFrom" name="addFrom" action="update-product" method="post">
	   		<c:if test="${product != null }">
	   			   		<div class="width50">
<!-- 	   			<div>
	   				<div class="input-block">
						<label>Photo du produit : </label><br>
						<input type="text" name="thumbnail" placeholder="Photo (*)" required>
						 <input type="file" name="thumbnail"><br>
						<img class="preview">
						<p class="error"></p>
					</div>
	   			</div> -->
	   			<input type="hidden" name="id" value="${product.id}">
	   			<div>
	   				<div class="input-block">
						<label>Photo du produit : </label><br>
						<input type="text" name="thumbnail" placeholder="Photo (*)" required value="${product.thumbnail}">
						<!--  <input type="file" name="thumbnail"><br>
						<img class="preview">-->
						<p class="error"></p>
					</div>
					
	   				<div class="input-block">
						<label>Nom du produit : </label><br>
						<input type="text" name="title" placeholder="Nom (*)" required value="${product.title}">
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label>description du produit : </label><br>
						<textarea name="description" rows="3" placeholder="description" required>${product.description}</textarea>
						<p class="error"></p>
					</div>
		   			<div class="input-block">
		   				<label>Prix Unitaire TTC :</label><br>
		   				<input name="price" type="number" placeholder="0" required value="${product.price}">
		   			</div>
		   			<div class="input-block">
	   					<label>Public :</label><br>
	   					<select name="public" required>
	   						<c:forEach items="${allPublics}" var="publicItem">
	   							<c:choose>
	   								<c:when test="${publicItem.id == product.public_id}"> 
	   									<option value="${publicItem.id}" selected="selected" >${publicItem.name}</option>
	   								</c:when>
	   								<c:otherwise>
	   									<option value="${publicItem.id}">${publicItem.name}</option>
	   								</c:otherwise>
	   							</c:choose>			
	   						</c:forEach>	
	                	</select>
	   				</div>
	   				<div class="input-block">
	   					<label>Categorie :</label><br>
	   					<select name="category" required>
	   						<c:forEach items="${categories}" var="category">
	   							<c:choose>
	   								<c:when test="${category.id == product.category_id}"> 
	   									<option value="${category.id}" selected="selected" >${category.name}</option>
	   								</c:when>
	   								<c:otherwise>
	   									<option value="${category.id}">${category.name}</option>
	   								</c:otherwise>
	   							</c:choose>			
	   						</c:forEach>	
	                	</select>
	   				</div>
	   			</div>
	   		</div>
	   			<!-- <div>
          	<img class="thumbnail" alt="" src="resources/img/${product.thumbnail}"> 
          </div> -->
	   		<button class="right" type="submit" onclick="valideAddForm()">Enregistrer</button>
	   		</c:if>

	   		</form>
       </div>
       
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/add.js"></script>
</body>
</html>