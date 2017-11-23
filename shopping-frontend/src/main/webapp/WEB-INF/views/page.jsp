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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->

<!-- Bootstrap core JavaScript -->


<script src="${js}/jquery.js"></script>

<!-- Bootstrap Minified Version -->
<script src="${js}/bootstrap.min.js"></script>


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

		<!-- Navigation -->
		<!-- Navigation Bar Will Comer here -->
		<%@include file="./shared/nav.jsp"%>


		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- This will get loaded when user clicks on About -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- This will get loaded when user clicks on About -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
		</div>
		<!-- Page Content End here-->



		<!-- This will get loaded when user clicks on Products -->
		<c:if
			test="${userClickAllProducts == true or userClickCategoryProducts==true}">
			<%@include file="list.jsp"%>
		</c:if>



		<!-- Loads when user clicks on manage products -->
		<c:if test="${userClickManageProducts == true}">
			<%@include file="manageProduct.jsp"%>
		</c:if>

		<c:if test="${userClickShowCart == true}">
			<%@include file="cart.jsp"%>
		</c:if>


		<c:if test="${userClickContact == true}">
			<%@include file="contact.jsp"%>
		</c:if>



	

	</div>


	<!-- When user clicks on view single product -->
	<!-- This will get loaded when user clicks on About -->








	<!-- Footer -->
	<!-- Footer Comes Here-->
	<%@include file="./shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Minified Version -->
	<script src="${js}/bootstrap.min.js"></script>


	<!-- Jqery Validator -->
	<script src="${js}/jquery.validate.js"></script>



	<!-- Jquery Data Table fields -->
	<script src="${js}/jquery.dataTables.js"></script>

	<!-- DataTable Bootstrap Javascript -->

	<script src="${js}/dataTables.bootstrap.js"></script>

	<!-- Bootbox library -->
	<script src="${js}/bootbox.min.js"></script>

	<script src="${js}/app.js"></script>

	<!-- Wrapper Class Finished-->
</body>

</html>
