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
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

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
		<c:if test="${userClickContact == true}">
 			<%@include file="contact.jsp"%>
		</c:if>
       </div>
       		<!-- Page Content End here-->


      
	<!-- This will get loaded when user clicks on Products -->
		<c:if test="${userClickAllProducts == true or userClickCategoryProducts==true}">
 			<%@include file="list.jsp"%>
		</c:if>
       </div>

		<!-- Footer -->
		<!-- Footer Comes Here-->
		<%@include file="./shared/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/popper.min.js"></script>
		<script src="${js}/app.js"></script>
		<script src="${js}/bootstrap.min.js"></script>

	</div>
	<!-- Wrapper Class Finished-->
</body>

</html>
