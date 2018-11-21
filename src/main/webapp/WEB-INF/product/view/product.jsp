<%@page import="java.text.DecimalFormat"%>
<%@page import="fr.ngando.product.controller.ProductServlet"%>
<%@page import="fr.ngando.product.domain.Product"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nos produits</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
	<%@include file="../../commons/view/header.jsp" %>
	<section class="container">
	   <div class="divProduit">
          <div>
          	<img class="thumbnail" alt="" src="resources/img/${product.thumbnail}"> 
          </div>
          <div>
          	<div class="text-right">
          	   <c:if test="${sessionScope.uGrant.equals('full')}">
          	   		<script type="text/javascript">
						function deleteProduct() {
							var txt;
							var r = confirm("Tu veux vraiment supprimer définitivement cet article ?");
							if (r == true) {
								document.location.href="delete-product?ref="+${product.id};
							} 
						}
					</script>
					<button type="button" class="btn-add" onclick="document.location.href='update-product?ref=${product.id}'" ><i class="fas fa-pen-alt"></i>Modifier</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn-remove" onclick="deleteProduct()"><i class="fas fa-trash-alt"></i>Supprimer</button>
					<br><br>
				</c:if>
          	</div>
            <h4>${product.title}</h4>
            <p>${product.description}</p>
            <div class="dashed"></div>
            <p> 
            	<span id="prixUnitaire" class="produitPrice">${product.print2df(product.price)} €</span>
              	<em>P.U. TTC</em>
            </p>
           	<div class="input-block">
              	<span>Qté : </span><input id="qte" name="qte" type="number" value="1" min="0" max="10">
              	<span>Total : </span><span id="prixTotal">${product.print2df(product.price)} €</span>
           	</div>
            <div class="dashed"></div>
            <br>
            <div class="input-block">
              	<button><i class="fas fa-cart-arrow-down"></i>Ajouter au panier</button>
            </div>  
          </div>
       </div>
       
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/product.js"></script>
</body>
</html>