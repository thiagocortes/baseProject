<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<html>
 <head>
   <link rel="stylesheet" href="../static/css/bootstrap.min.css">
   <script src="../static/js/jquery-3.3.1.min.js"></script>
   <script src="../static/js/bootstrap.min.js"></script>
 </head>
 <tiles:insertDefinition name="template">
   <tiles:putAttribute name="corpo">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8 col-md-7">
                <div class="card">
                    <div class="content">
                    	<spring:url value="${aluno.id == null ? '/aluno/salvar' :  '/aluno/atualizar'}" var="save"/>
                    	<springform:form method="POST" action="${save}" modelAttribute="aluno">
                    	<springform:hidden path="id" />
                    		<fieldset>
	                        	<legend>Dados Pessoais</legend>
	                            <div class="row">
                            	 	<div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="nome">Nome</label>
	                                        <springform:input id="nome" path="nome" cssClass="form-control border-input" />
	                                        <springform:errors path="nome" cssClass="label label-danger" />
	                                    </div>
	                                </div>
	                                <div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="email">Email</label>
	                                        <springform:input type="email" id="email" path="email" cssClass="form-control border-input" />
	                                        <springform:errors path="email" cssClass="label label-danger" />
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="row">
	                                
	                                <div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="cpf">CPF</label>
	                                        <springform:input type="text" id="cpf" path="cpf" cssClass="cpf form-control border-input" />
	                                        <springform:errors path="cpf" cssClass="label label-danger" />
	                                    </div>
	                                </div>
	                                <div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="rg">RG</label>
	                                        <springform:input type="text" id="rg" path="rg" cssClass="form-control border-input" />
	                                        <springform:errors path="rg" cssClass="label label-danger" />
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="row">
	                            	<div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="naturalidade">Naturalidade</label>
	                                        <springform:input type="text" id="naturalidade" path="naturalidade" cssClass="form-control border-input" />
	                                    </div>
	                                </div>
	                                
	                                <div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="nacionalidade">Nacionalidade</label>
	                                        <springform:input type="text" id="nacionalidade" path="nacionalidade" cssClass="form-control border-input" />
	                                    </div>
	                                </div>
	                            </div>
	
	                            <div class="row">
	                                
	                                <div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="dataNascimento">Data de Nascimento</label>
	                                        <springform:input type="date" id="dataNascimento" path="dataNascimento" cssClass="form-control border-input" />
	                                        <springform:errors path="dataNascimento" cssClass="label label-danger" />
	                                    </div>
	                                </div>
	                                
	                                <div class="col-md-6">
	                                    <div class="form-group">
	                                        <label for="sexo">Sexo</label>
	                                        <springform:select path="sexo" cssClass="form-control">
	                                        	<springform:option value="">Selecione</springform:option>
												<springform:options items="${sexos}" itemLabel="descricao" />
											</springform:select>
											<springform:errors path="sexo" cssClass="label label-danger" />
	                                    </div>
	                                </div>
	                            </div>
							</fieldset>
                            <div class="text-center">
                                <button type="submit" class="btn btn-info btn-fill btn-wd">Salvar</button>
                                <a href="${pageContext.request.contextPath}/aluno/cancelar" class="btn btn-danger btn-fill btn-wd">Cancelar</a> 
                            </div>
                            <div class="clearfix"></div>
                        </springform:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </tiles:putAttribute>
    </tiles:insertDefinition>
</html>
