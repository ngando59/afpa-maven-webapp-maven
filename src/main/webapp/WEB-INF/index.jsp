<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
	<%@include file="commons/view/header.jsp" %>
	<section>
		<p class="container text-center">
			Welcome <span class="blue">${user}</span> on WebApp !	
		</p>
		<section class="container home">
            <c:if test="${products != null}">
                <div class="divalaune">
	               <div class="navigation left">
	                    <img id="navPred" src="resources/img/left.png" />
	                </div>
	               	<img id="alaune" src="resources/img/${products.get(0).thumbnail}" alt="" data-id="0">
	                <div class="navigation right">
	                    <img id="navNext" src="resources/img/right.png" />
	                </div>
	            </div> 
	            <div class="tumbnails">
	            	<c:forEach items="${products}" var="product">
	            		<img class="thumbnail" src="resources/img/${product.thumbnail}" alt="" data-id="${products.indexOf(product)}">
	            	</c:forEach>            	
	            </div>
            </c:if>
        </section>
	</section>
	<%@include file="commons/view/footer.jsp" %>
</div>
<script type="text/javascript" src="resources/js/carousel.js"></script>
</body>
</html>