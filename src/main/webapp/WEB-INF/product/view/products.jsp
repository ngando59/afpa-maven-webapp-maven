<%@page import="java.text.DecimalFormat"%>
<%@page import="fr.ngando.product.controller.ProductsServlet"%>
<%@page import="fr.ngando.product.domain.Product"%>
<%@page import="java.util.ArrayList"%>
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
	<section class="container have2Side">
		<aside class="leftSide">
			<h3>Nos produits</h3>
			<ul>
				<c:forEach items="${categories}" var="category">
					<li><a href="products?url=${category.tag}">${category.name}</a></li>
				</c:forEach>
			</ul>
		</aside>
		<section class="rightSide">
			<h1 class="coral">${itemsTitle}</h1>
			 <div class="items">
                <c:forEach items="${products}" var="product">
    				<div class="item">
                    <a href="product?ref=${product.id}">
                        <img src="resources/img/${product.thumbnail}" alt="">
                        <h3>${product.title}</h3>
                        <p>
                           ${product.description}
                        </p>
                        <span class="price">${product.print2df(product.price)} €</span>
                    </a>
                </div>
				</c:forEach>
            </div> 
		</section>
	</section>
	<%@include file="../../commons/view/footer.jsp" %>
</div>
</body>
</html>