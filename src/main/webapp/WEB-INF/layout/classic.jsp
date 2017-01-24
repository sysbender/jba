<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>


	<tiles:insertAttribute name="body" />
	<br>
	<br>
	<div class="text-center">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>