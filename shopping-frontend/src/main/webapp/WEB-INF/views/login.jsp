<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Data Table Bootstrap-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/app.css" rel="stylesheet">



</head>

<body>

	<!-- Wrapper Class -->
	<div class="wrapper">

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
   <div class="container">
      <ul class="nav navbar-nav navbar-left">
        <li> <a class=navbar-brand" href="${contextRoot}/home">Home</a></li>
      </ul>
   </div>
</nav>

<br><br>
		<div class="container">
            <%--If the credentials are wrong --%>		
 		<c:if test="${not empty message}">
		  <div class="row">
		       <div class="col-md-offset-3 col-md-6">
		         
		          <div class="alert alert-danger">${message}</div>
		         
		       </div>
		      
		  </div>
		  
		</c:if>
          <%--This displays when user logsout --%>		
 		<c:if test="${not empty logout}">
		  <div class="row">
		       <div class="col-md-offset-3 col-md-6">
		         
		          <div class="alert alert-success">${logout}</div>
		         
		       </div>
		      
		  </div>
		  
		</c:if>

			<div class="col-md-6 col-md-offset-3">

				<div class="panel panel-primary">

					<div class="panel-heading">

						<h4>Login</h4>
					</div>

					<div class="panel-body">

						<form action="${contextRoot}/login" method="post"  class="form-horizontal" id="loginForm">

							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-8">
									<input type="email" name="username" id="username" class="form-control"
										placeholder="Email" />
                                    
								</div>

							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Password</label>
								<div class="col-md-8">
									<input type="password" name="password" id="password"
										class="form-control" placeholder="Password" />
                                    
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" value="Login" class="btn btn-primary" />
					                  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />   
								</div>
							</div>



						</form>

						<div class="panel-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>

					</div>
				</div>
			</div>
</div>






		<!-- Footer -->
		<!-- Footer Comes Here-->
		<%@include file="./shared/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/popper.min.js"></script>

		<script src="${js}/bootstrap.min.js"></script>



		<script src="${js}/app.js"></script>

		<!-- Wrapper Class Finished-->
</body>

</html>
