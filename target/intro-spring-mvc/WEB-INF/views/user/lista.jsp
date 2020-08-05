<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Lista de Usuários</title>
<spring:url var="css" value="/static/css/bootstrap.css"></spring:url>

<link type="text/css" rel="stylesheet" href="${css }">
</head>
<body>
	<div class="container">

		<h1>Lista de Usuários</h1>
		<hr>
		<div>
			<spring:url value="/usuario/cadastro" var="cadastro" />
			<a class="btn btn-primary" href="${cadastro}">Novo Cadastro</a>
		</div>
		<hr>
		<div class="${message == null ? 'alert-default' : 'alert-success'}">
			<div class="panel-heading">
				<span>${message == null ? '&nbsp;' : message}</span>
			</div>
		</div>
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>DATA DE NASCIMENTO</th>
					<th>TIPO SEXO</th>
					<th>ACÃO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cadaUsuario" items="${usuarios }">
					<tr>
						<td>${cadaUsuario.id }</td>
						<td>${cadaUsuario.nome }&nbsp;${cadaUsuario.sobrenome }</td>

						<td><fmt:parseDate var="date"
								value="${cadaUsuario.dtNascimento }" pattern="yyyy-MM-dd"
								type="date" /> <fmt:formatDate value="${date}"
								pattern="dd-MM-yyyy" type="date" /></td>
						<td>${cadaUsuario.sexo.descricao }</td>
						<td><spring:url value="/usuario/update/${cadaUsuario.id}"
								var="update" /> <a class="btn btn-info" href="${update}">Editar</a>

							<spring:url value="/usuario/deletar/${cadaUsuario.id}" var="del" />
							<a class="btn btn-danger" href="${del}">Excluir</a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<footer>
		<p>
			<img src="https://www.devmedia.com.br/favicon.png?w=112" height="40" />
			&copy; 2020 DevMedia
		</p>
	</footer>
<!-- 	</div> -->
</body>
</html>