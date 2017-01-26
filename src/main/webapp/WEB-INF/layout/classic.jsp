<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<%@ taglib prefix="tilesx"
		uri="http://tiles.apache.org/tags-tiles-extras"%>
	<tilesx:useAttribute name="current" />

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/"/>">Java
						Blog Aggregator</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class=" ${ current == 'index' ? 'active' : ''}"><a
							href="<spring:url value="/"/>">Home</a></li>


						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class=" ${ current == 'users' ? 'active' : ''}"><a
								href="<spring:url value="/users.html"/>">Users</a></li>
						</security:authorize>

						<li class=" ${ current == 'register' ? 'active' : ''}"><a
							href="<spring:url value="/register.html"/>">Register</a></li>



						<security:authorize access="! isAuthenticated()">
							<li class=" ${ current == 'login' ? 'active' : ''}"><a
								href="<spring:url value="/login.html"/>">Login</a></li>
						</security:authorize>

						<!-- only for logined users -->
						<security:authorize access="isAuthenticated()">

							<li class=" ${ current == 'account' ? 'active' : ''}"><a
								href="<spring:url value="/account.html"/>">My Account</a></li>

							<li><a href="<spring:url value="/logout"/>">Logout</a></li>
						</security:authorize>

						<li><a href="#">Contact</a></li>

					</ul>

				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>



		<tiles:insertAttribute name="body" />
		<br> <br>
		<div class="text-center">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
	<!-- /container -->




</body>
</html>