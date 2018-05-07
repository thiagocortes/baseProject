<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>SGE</title>
   <link rel="stylesheet" href="static/css/bootstrap.min.css">
   <script src="static/js/jquery-3.3.1.min.js"></script>
   <script src="static/js/bootstrap.min.js"></script>
 </head>
 <body>
   <nav class="navbar navbar-default" role="navigation">
     <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
         <span class="sr-only"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="../index.jsp">Início</a>
      </div>

      <div class="collapse navbar-collapse" id="navbar-1">
        <ul class="nav navbar-nav">
         <li class="dropdown">
	         <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Cadastros<span class="caret"></span></a>
	         <ul class="dropdown-menu" role="menu">
	            <li><a href="${pageContext.request.contextPath}/disciplina/list">Disciplinas</a></li>
	            <li><a href="${pageContext.request.contextPath}/aluno">Alunos</a></li>
	            <li><a href="${pageContext.request.contextPath}/professor/list">Professores</a></li>
	            
	            <li><a href="${pageContext.request.contextPath}/funcionario/list">Funcionários</a></li>
	            <li><a href="${pageContext.request.contextPath}/nivel/list">Níveis</a></li>
	            <li><a href="${pageContext.request.contextPath}/turma/list">Turma</a></li>
	            
	            <li><a href="${pageContext.request.contextPath}/curso/list">Cursos</a></li>
	            <li><a href="${pageContext.request.contextPath}/turno/list">Turnos</a></li>
	            <li><a href="${pageContext.request.contextPath}/horario_turno/list">Horários Turnos</a></li>
	         </ul>
         </li>
         
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Acadêmico<span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.request.contextPath}/preparaCadastroPaciente.do">Cadastrar</a></li>
            <li><a href="${pageContext.request.contextPath}/paciente/listar.do">Listar</a></li>
           </ul>
         </li>
         <li>
           <a href="${pageContext.request.contextPath}/preparaCadastroConsulta.do">Marcar Consulta</a>
         </li>
         <li>
           <a href="${pageContext.request.contextPath}/preparaCadastroAtendimento.do">Realizar / Visualizar Atendimento</a>
         </li>
        </ul>
      </div>
     </div>
   </nav>
 
   <c:if test="${mensagem != null}">
      <div class="${mensagem.tipoMensagem.classeCss}" role="alert" style="margin-left: 20px; margin-right: 20px;">${mensagem.texto}</div>
   </c:if>
 
   <div class="panel panel-default" style="margin: 20px;">
   	<div class="panel-body">
      <tiles:insertAttribute name="corpo" />
     </div>
   </div>
 </body>
</html>