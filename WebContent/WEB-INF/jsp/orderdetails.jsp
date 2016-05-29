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
	<!-- Latest compiled and minified CSS -->

<!-- Own theme -->
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<nav class="container">
		<div class="col-md-6">
			<h1>COMP5347 Assignment 2 ADMIN CENTER</h1>
			<h2>Order Details</h2>
		</div>
		<div class="col-md-6" id="navs">
			<p>
				<a href="/SOSS/">Home</a>
			</p>
		</div>
		<div class="col-md-12">
			<hr>
		</diV>
	</nav>
	<section class="container">
 	<div class="col-md-12">
    <div class="row">
     <table class= "table" data-toggle="table" data-height="299">
    <thead>
        <tr>
            <th>Order ID</th>
            <th>Product ID</th>
            <th>Qty</th>
            <th>Product Name</th>

        </tr>
    </thead>
    <tbody>
          <c:forEach var="order" items="${orders}">
          <tr>
    <td>${order.order_id}</td>
        <td>${order.productid}</td>
        <td>${order.qty}</td>
        <td>${order.name}</td>

    		</c:forEach>
   	</tbody>
</table>
<table class= "table" data-toggle="table" data-height="299">
    <thead>
        <tr>
            <th>Stock ID</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Location</th>
 			<th>Qty</th>
        </tr>
    </thead>
    <tbody>
          <c:forEach var="warehouse" items="${warehouses}">
          <tr>
    <td>${warehouse.stock_id}</td>
        <td>${warehouse.product_id}</td>
        <td>${warehouse.product_name}</td>
        <td>${warehouse.location}</td>
 		<td>${warehouse.qty}</td>
    		</c:forEach>
   	</tbody>
</table>
<c:if test="${not empty }">
<p>
						Welcome
					</p>
</c:if>
        </div>
    </div>
	</section>
</body>
<!-- BS JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>