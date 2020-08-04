	<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<!DOCTYPE html>
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Cadastro de Usuários</title>
		</head>
		<body>
			<div class="container">
				<h1>Cadastro de Usuários</h1>
			<hr>
				<div>

					<spring:url value="/usuario/todos" var="home"/>
					<a class="btn btn-default" href="${home}">Home</a>
				</div>
			
			</div>
			<div>
			<!-- modelAttribute e um componet do Spring que cria uma referencia a classe de dominio Model. No caso referenciada pela variavel usuario 
				action ea tag utlizada para trabalhar com as URI. No caso do Spring utilizaremos os recursos da Taglib Spring  spring:url value="" com o caminnho do controller. A variavel var ira guardar esse caminho 
				aqui represendado como como save. Dessa forma a action recebe o valor da variavel "save" representado 
				expressao "${save}" 
				form:input tambem e um mecanismo do Spring, ao declaramos devemos indicar o path e ele fara a conexao entre o formulario e o objeto de domini. Lancando uma excecao caso a variavel nao exista.  
				/>
			-->
				<spring:url value="${usuario.id == null ? '/usuario/save' : '/usuario/update'}" var="save"/>
				<form:form modelAttribute="usuario" action="${save}" method="post"> 
					<form:hidden path="id"/>
					<div class="form-group">
						<label for="nome">Nome: </label>
						<form:input path="nome" class="form-control"/>
					</div>
					
					<div class="form-group">
						<label for="sobrenome">Sobrenome: </label>
						<form:input path="sobrenome" class="form-control"/>
					</div>
					
					<div class="form-group">
						<label for="dtNascimento">Data de Nascimento: </label>
						<form:input path="dtNascimento" class="form-control" type="date"/>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Confirmar</button>
					</div>
				</form:form>
			</div>
		<footer class="footer">
			<p><img src="https://www.devmedia.com.br/favicon.png?w=112" height="40"/> &copy; 2020 DevMedia</p>
		</footer>
	</body>
	</html>