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


	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
   <div class="container">
      <ul class="nav navbar-nav navbar-left">
        <li> <a class=navbar-brand" href="${contextRoot}/home">Home</a></li>
      </ul>
   </div>
</nav>
	<br/><br/>
	<div class="content">
        <div class="container">
           <div class="row">
             <div class="col-xs-12">
                <div class="jumbotron">
                  
                  <h1>${errorTitle}</h1>
                  </hr>
                  
                  <blockquote>
                     ${errorDescription }
                  </blockquote>
                  
                </div>
             </div>
           </div>
        </div>
	</div>


	<!-- Footer -->
	<!-- Footer Comes Here-->
	<%@include file="./shared/footer.jsp"%>
</body>

</html>
