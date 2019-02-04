<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Viewport Meta Tag -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Authoring Tool</title>

<!-- Website logo icon -->
<link rel="icon" href="${pageContext.request.contextPath}/images/site-logo.png" type="image/gif" sizes="16x16">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value='/css/bootstrap.3.3.7.min.css'/>">

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Share" rel="stylesheet">

<!-- Font awesome -->
<link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>">

<link rel="stylesheet" href="<c:url value='/css/custom/global.css'/>">

</head>
<body>
	<div class="panel-heading">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand aq-brand-head" href="${pageContext.request.contextPath}/home"><span class="fa fa-gear fa-spin aq-login-spin"></span> Authoring Tool</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/login"><span class="fa fa-sign-in fa-1x" aria-hidden="true"></span> Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	
	<div class="panel-body">
		<div class="container-fluid">
			<div class="row">
		        <img class="img-responsive" alt="Wheel" src="${pageContext.request.contextPath}/images/myphoto.png">
		    </div>
		</div>
	</div>
	
<!-- jQuery library -->
<script src="<c:url value='/js/jquery-3.2.1.min.js'/>"></script>

<!-- Tether -->
<script src="<c:url value='/js/tether.min.js'/>"></script>

<!-- Bootstrap JS -->
<script src="<c:url value='/js/bootstrap.3.3.7.min.js'/>"></script>

</body>
</html>