<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>


	<div class="container p-2">
		<h1>Ninja Gold</h1>
		<%-- 	<p> Your Gold:  <c:out value="${gold}"></c:out></p> --%>
		<p>
			You Gold: <span
				class="border border-primary border-3 m-2 d-inline-block ps-4 pe-4">${gold}</span>
		</p>
		<div class=row>

			<div class="card col mx-2 ">
				<form action="/gold" method="POST">
					<h2 class="text-center">Farm</h2>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="lugar" value="farm" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Find
						Gold!</button>
				</form>
			</div>

			<div class="card col mx-2 ">
				<form action="/gold" method="POST">
					<h2 class="text-center">Cave</h2>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="lugar" value="cave" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Find
						Gold!</button>
				</form>
			</div>

			<div class="card col mx-2 p-2">
				<form action="/gold" method="POST">
					<h2 class="text-center">House</h2>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="lugar" value="house" />
					<button type="submit" class="btn btn-info" id="Farm" name="Farm">Find
						Gold!</button>
				</form>
			</div>

			<div class="card col mx-2 ">
				<form action="/gold" method="POST">
					<h2 class="text-center">Casino</h2>
					<p>(earns/lost 0-50 gold)</p>
					<input type="hidden" name="lugar" value="casino" />
					<button type="submit" class="btn btn-info " id="Farm" name="Farm">Find
						Gold!</button>
				</form>
			</div>

		</div>
		<h4 class="m-2">ACTIVIDADES</h4>
			<iframe src="/actividades" title="marco actividades"></iframe>
	</div>

<%-- 	<c:forEach var="actividad" items="${actividades }"> --%>
<%-- 		<c:if test="${actividad.contains('earned') }"> --%>

<!-- 			<p class="text-success"> -->
<%-- 				<c:out value="${actividad }" /> --%>
<!-- 			</p> -->
<%-- 		</c:if> --%>
<%-- 		<c:if test="${actividad.contains('lost') }"> --%>

<!-- 			<p class="text-danger"> -->
<%-- 				<c:out value="${actividad }" /> --%>
<!-- 			</p> -->
<%-- 		</c:if> --%>
<%-- 	</c:forEach> --%>




</body>
</html>
