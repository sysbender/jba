<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>user name</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="user" items="${users}">

			<tr>
				<td><a href="<spring:url value='/users/${user.id}.html'/>">${user.name }</a>
				</td>
				<td><a href="<spring:url value='/users/remove/${user.id}.html'/>" class="btn btn-danger">remove :${user.name }</a>
				</td>
			</tr>
		</c:forEach>




	</tbody>
</table>