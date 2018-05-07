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
<body>
	<div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Esqueci minha senha</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <spring:url value="/usuario/login" var="login"/>
                        <springform:form method="POST" action="${login}" modelAttribute="usuario">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                   			    <label for="nome">E-mail</label>
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <springform:input id="email" path="email" cssClass="form-control border-input" />
                                <springform:errors path="email" cssClass="label label-danger" />                               
                            </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                
                                <label for="nome">Senha</label>
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <springform:input id="senha" type="password" path="senha" cssClass="form-control border-input" />
                                <springform:errors path="senha" cssClass="label label-danger" />  
                                
                            </div>
                                    
                            <div style="margin-top:10px" class="form-group">
                                <div class="col-sm-12 controls">
                                  	<button type="submit" class="btn btn-info btn-fill btn-wd">Login</button>
                                </div>
                            </div>

                            <div class="form-group">
                                 <div class="col-md-12 control">
                                     <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                         Não tem uma conta? 
                                     <a href="${pageContext.request.contextPath}/usuario/novo">
                                         Crie agora
                                     </a>
                                     </div>
                                 </div>
                             </div>    
                          </springform:form>
                      </div>                     
                  </div>  
        </div>
    </div>

</body>
</html>