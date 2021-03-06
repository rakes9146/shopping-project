<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<!-- <nav class="navbar  navbar-dark bg-dark fixed-top">  -->
<nav class="navbar navbar-expand-lg navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="${contextRoot}/home">Electronics
			Shopping</a>
		<button class="navbar-toggle" type="button" data-toggle="collapse"
			data-target="#navbarResponsive">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="nav navbar-nav">
				<!--  	<li class="nav-item" id="home"><a class="nav-link" href="${contextRoot}/home">Home
							<span class="sr-only">(current)</span>
					</a></li>-->

				<li class="nav-item" id="listProducts"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Product</a></li>


				<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item" id="manageProducts"><a class="nav-link"
						href="${contextRoot}/manage/products">Manage Product</a></li>
				</security:authorize>

				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="signup"><a class="nav-link"
						href="${contextRoot}/register">Sign Up</a></li>
					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>


				<security:authorize access="isAuthenticated()">
					<li class="nav-item"></li>
					<li class="nav-item"><a class="nav-link" href="#">${userModel.fullName}</a></li>

					<security:authorize access="hasAuthority('USER')">
						<li id="userCart"><a href="${contextRoot}/cart/show"> <span
								class="glyphicon glyphicon-shopping-cart">${userModel.cart.cartLines}</span>
								<span class="badge">0</span> -&#8377;
								${userModel.cart.grandTotal}
						</a></li>

					</security:authorize>



					<li><a href="${contextRoot}/perform-logout">Logout</a></li>
				</security:authorize>

			</ul>



		</div>
	</div>
</nav>
<script>
	window.userRole = '${userModel.role}';
</script>