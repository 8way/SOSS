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
				<h2>Order Details</h2>
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
				<form class="form-horizontal" method="post">
					<fieldset>
						<!-- full-name input-->
						<div class="control-group">
							<label class="control-label">Full Name</label>
							<div class="controls">
								<input id="full-name" name="full-name" type="text" class="input-xlarge">
								<p class="help-block"></p>
							</div>
						</div>
						<!-- address-line1 input-->
						<div class="control-group">
							<label class="control-label">Address</label>
							<div class="controls">
								<input id="address-line1" name="address" type="text" class="input-xlarge">
								<p class="help-block">Street address, P.O. box, company name, c/o</p>
							</div>
						</div>
						<!-- city input-->
						<div class="control-group">
							<label class="control-label">City / Town</label>
							<div class="controls">
								<input id="city" name="city" type="text" class="input-large">
								<p class="help-block"></p>
							</div>
						</div>
						<!-- region input-->
						<div class="control-group">
							<label class="control-label">State / Province / Region</label>
							<div class="controls">
								<input id="region" name="region" type="text" class="input-large">
								<p class="help-block"></p>
							</div>
						</div>
						<!-- postal-code input-->
						<div class="control-group">
							<label class="control-label">Zip / Postal Code</label>
							<div class="controls">
								<input id="postal-code" name="postal-code" type="text" class="input-medium">
								<p class="help-block"></p>
							</div>
						</div>
						<!-- country select -->
						<div class="control-group">
							<label class="control-label">Country</label>
							<div class="controls">
								<select id="country" name="country" class="input-xlarge">
									<option value="" selected="selected">---</option>
									<option value="AU">Australia</option>
									<option value="US">United States</option>
								</select>
							</div>
						</div>
					</fieldset>
					<br>
					<input type="submit" class="btn btn-info" value="Submit">
				</form>
			</div>
		</section>
	</body>
	<!-- BS JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</html>