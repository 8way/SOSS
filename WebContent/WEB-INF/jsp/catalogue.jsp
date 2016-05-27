<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<!-- BootStrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<!-- BS theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Own theme -->
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<nav class="container">
		<div class="col-md-6">
			<h1>COMP5347 Assignment 2</h1>
			<h2>Product Catalogue</h2>
		</div>
		<div class="col-md-6" id="navs">
			<p>
				<c:if test="${not empty user}">
					<p>
						Welcome <b>${user.userName}</b>
					</p>
					<a href="order">Track Order</a><br>
					<a href="logout">Logout</a>
				</c:if>
				<c:if test="${empty user}">
					<a href="login">Log In</a>
				</c:if>
			</p>
		</div>
		<div class="col-md-12">
			<hr>
		</diV>
	</nav>
	<section class="container">
		<c:forEach var="product" items="${products}">
			<article id="book" class="col-md-6">
				<h3 id="bookName">${product.name}</h3>
				<a href=""><img src="${product.imageUrl}" alt="bookPhoto"
					id="bookPhoto" height="200px"></a>
				<p>Price: $${product.price}</p>
				<p>Description: ${product.description}</p>
				<a href="carts/add/${product.productId}" class="add">Add to Cart</a>
			</article>
		</c:forEach>
	</section>
	<jsp:include page="cart.jsp"></jsp:include>