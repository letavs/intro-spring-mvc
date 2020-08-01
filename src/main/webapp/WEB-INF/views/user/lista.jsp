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
</head>
<body>
	<div class="container">
<!-- 		 O container será usado pelo bootstrap -->
		<h1>Lista de Usuários</h1>
		<hr>
		<div>

			<spring:url value="/usuario/cadastro" var="cadastro"/>
			<a class="btn btn-default" href="${cadastro} ">Novo Usuário</a>
		</div>
		<hr>
		<div class="panel-default">
			<div class="panel-heading">
				 <span>${message == null ? '&nbsp;' : message}</span>
			</div>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>ACÃO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cadaUsuario" items="${usuarios }"> 
						<tr>
							<td>${cadaUsuario.id }</td>
							<td>${cadaUsuario.nome }&nbsp;${cadaUsuario.sobrenome }</td>
							<td>
							
								<spring:url value="/usuario/update/${cadaUsuario.id}" var="update"/>
								<a class="btn btn-info" href="${update}">Editar</a> 
								
								<spring:url value="/usuario/deletar/${cadaUsuario.id}" var="del"/>
								<a class="btn btn-danger" href="${del}">Excluir</a>
							</td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<p><img src="https://www.devmedia.com.br/favicon.png?w=112" height="40"/> &copy; 2020 DevMedia</p>
	<hr>
</body>
</html>