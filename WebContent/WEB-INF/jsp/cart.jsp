<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="cart">
	<c:if test="${cart.isEmpty()}">

		<nav class="container">
			<div class="col-md-12">
				<hr>
				<h2>Cart</h2>
				<c:if test="${not empty error}">
					<p id="carterror" style="color: red;">${error}</p>
				</c:if>
			</diV>
		</nav>
		<section class="container">
			<div class="col-md-12">
				<table id="carttable" class="table">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cartItem" items="${cart.items}">
							<tr>
								<td>${cartItem.product.name}</td>
								<td><a href="carts/remove/${cartItem.product.productId}"
									class="remove"><span class="glyphicon glyphicon-minus"></a></span>
									${cartItem.quantity} <a
									href="carts/add/${cartItem.product.productId}" class="add"><span
										class="glyphicon glyphicon-plus"></span></a></td>
								<td>${cartItem.calculateSubTotal()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-12" id="ctotal">
				<h5>Total</h5>
				<p>$${cart.total}</p>
				<c:if test="${not empty user}">
					<a class="checkout" href="carts/check">Checkout</a>
				</c:if>
				<c:if test="${empty user}">
					<a href="login">Log In</a>
				</c:if>
			</div>
		</section>
	</c:if>
</div>
<footer> </footer>
</body>

<!-- BS JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".add").unbind().click(function(e) {
			e.preventDefault();
			$("#cart").load($(this).attr("href"));
		});
		$(".remove").unbind().click(function(e) {
			e.preventDefault();
			$("#cart").load($(this).attr("href"));
		});
		$(".checkout").unbind().click(function(e) {
			e.preventDefault();
			$("#cart").load($(this).attr("href"));
			
			/* var text = "${error}"; */
			setTimeout(function(){
				if (!$("#carterror" ).length) {
					window.location.href = "details";
				}
			}, 500);
			
		});
	})
</script>
</html>