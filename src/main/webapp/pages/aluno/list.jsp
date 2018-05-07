<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
   <link rel="stylesheet" href="../static/css/bootstrap.min.css">
   <script src="../static/js/jquery-3.3.1.min.js"></script>
   <script src="../static/js/bootstrap.min.js"></script>
 </head>
 <tiles:insertDefinition name="template">
   <tiles:putAttribute name="corpo">
   
     <springform:form method="GET" action="${pageContext.request.contextPath}/aluno/pesquisar" modelAttribute="aluno">
	     <fieldset>
	     	<legend>Alunos</legend>
		      <div style="width: 300px;">
		        <div class="form-group">
			        <label for="nome">Nome</label>
			        <springform:input id="nome" path="nome" cssClass="form-control" />
		        </div>
		        <div class="form-group">
			        <label for="email">E-mail</label>
			        <springform:input id="email" path="email" cssClass="form-control" />
		        </div>
		      </div>
	      </fieldset>
	   	  <input type=submit value="Pesquisar" class="btn btn-primary" />
	   	  <a href="${pageContext.request.contextPath}/aluno/novo" class="btn btn-default">Novo</a>
     </springform:form>
     <div class="content table-responsive table-full-width" style="margin-top: 50px;">
          <table class="table">
              <thead>
              	  <tr>
              	  	  <th>Matricula</th>
	                  <th>Nome</th>
	              	  <th>Email</th>
	              	  <th>Nascimento</th>
	              	  <th>Ação</th>
             	  </tr>
              </thead>
              <tbody>
              <c:forEach var="item" items="${alunos}">
                  <tr>
                  	<td>${item.matricula}</td>
                  	<td>${item.nome}</td>
                  	<td>${item.email}</td>
                  	
                  	<fmt:formatDate var="formatDate"
                                value="${item.dataNascimento}"
                                type="date"
                                pattern="dd/MM/yyyy" />
                  	
                  	<td> <c:out value="${formatDate}"/></td>
                  	<td>
                  		<a href="${pageContext.request.contextPath}/aluno/get?id=${item.id}" class="btn btn-success btn-icon">Editar</a> 
                  		<a href="${pageContext.request.contextPath}/aluno/excluir?id=${item.id}" class="btn btn-danger btn-icon">Excluir</a>
                  	</td>
                  </tr>
              </c:forEach>
              </tbody>
          </table>
     </div>
     
   </tiles:putAttribute>
 </tiles:insertDefinition>
</html>