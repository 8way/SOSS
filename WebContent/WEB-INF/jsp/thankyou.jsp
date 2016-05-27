<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- BootStrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<!-- BS theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<nav class="container">
			<div class="col-md-6">
				<h1>COMP5347 Assignment 2</h1>
				<h2>Order Confirmation</h2>
			</div>
			<div class="col-md-6" id="navs">
				<p><a href="/SOSS/">Home</a></p>
			</div>
			<div class="col-md-12">
				<hr>
			</diV>
		</nav>
		<section class="container">
			<div class="col-md-12">
				<p class="confirmation">Your order has been placed and will be on its way shortly.</p>
				<p class="confirmation">You can check on the order here: <a href="order">link</a><p>
				<p class="confirmation">Click <a href="/SOSS/">here</a> to return to home.</p>
			</div>
		</section>
	</body>
	<!-- BS JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</html>