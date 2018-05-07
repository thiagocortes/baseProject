var app = angular.module('app',['ngRoute', 'ngResource', 'ngAnimate']);

app.config(function($routeProvider){
	$routeProvider
	.when("/usuarios", {controller: "usuarioController", templateUrl: "pages/list.html"})
	.when("/usuario/edit/:id", {controller: "usuarioController", templateUrl: "pages/form.html"})
	.when("/usuario/new", {controller: "usuarioController", templateUrl: "pages/form.html"})
	
	.when("/alunos", {controller: "alunoController", templateUrl: "pages/aluno/list.html"})
	.when("/aluno/edit/:id", {controller: "alunoController", templateUrl: "pages/aluno/form.html"})
	.when("/aluno/new", {controller: "alunoController", templateUrl: "pages/aluno/form.html"})
	
	.when("/professores", {controller: "professorController", templateUrl: "pages/professor/list.html"})
	.when("/professor/edit/:id", {controller: "professorController", templateUrl: "pages/professor/form.html"})
	.when("/professor/new", {controller: "professorController", templateUrl: "pages/professor/form.html"})
	
	.when("/funcionarios", {controller: "funcionarioController", templateUrl: "pages/funcionario/list.html"})
	.when("/funcionario/edit/:id", {controller: "funcionarioController", templateUrl: "pages/funcionario/form.html"})
	.when("/funcionario/new", {controller: "funcionarioController", templateUrl: "pages/funcionario/form.html"})
	
	.when("/disciplinas", {controller: "disciplinaController", templateUrl: "pages/disciplina/list.html"})
	.when("/disciplina/edit/:id", {controller: "disciplinaController", templateUrl: "pages/disciplina/form.html"})
	.when("/disciplina/new", {controller: "disciplinaController", templateUrl: "pages/disciplina/form.html"})
	
	.when("/niveis", {controller: "nivelController", templateUrl: "pages/nivel/list.html"})
	.when("/nivel/edit/:id", {controller: "nivelController", templateUrl: "pages/nivel/form.html"})
	.when("/nivel/new", {controller: "nivelController", templateUrl: "pages/nivel/form.html"})
	
	.when("/turmas", {controller: "turmaController", templateUrl: "pages/turma/list.html"})
	.when("/turma/edit/:id", {controller: "turmaController", templateUrl: "pages/turma/form.html"})
	.when("/turma/new", {controller: "turmaController", templateUrl: "pages/turma/form.html"})
	
	.when("/cursos", {controller: "cursoController", templateUrl: "pages/curso/list.html"})
	.when("/curso/edit/:id", {controller: "cursoController", templateUrl: "pages/curso/form.html"})
	.when("/curso/new", {controller: "cursoController", templateUrl: "pages/curso/form.html"})
	
	.when("/turnos", {controller: "turnoController", templateUrl: "pages/turno/list.html"})
	.when("/turno/edit/:id", {controller: "turnoController", templateUrl: "pages/turno/form.html"})
	.when("/turno/new", {controller: "turnoController", templateUrl: "pages/turno/form.html"})
	
	.when("/horariosTurnos", {controller: "horariosTurnoController", templateUrl: "pages/horario_turno/list.html"})
	.when("/horariosTurno/edit/:id", {controller: "horariosTurnoController", templateUrl: "pages/horario_turno/form.html"})
	.when("/horariosTurno/new", {controller: "horariosTurnoController", templateUrl: "pages/horario_turno/form.html"})
	
	.otherwise({redirectTo: "/"});
});

app.controller('usuarioController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {

	$scope.listarUsuarios = function(){
		$http.get("users/findAll").success(function(data){
			$scope.usuarios = data;
			console.log("Data: "+data);
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.openNew = function () {
		$scope.usuario = {};
		$location.path('/usuario/new');
    }
	$scope.cancelar = function () {
		$scope.usuario = {};
		$location.path('/usuarios');
    } 
    $scope.salvarUsuario = function () {
	    $http.post("users", $scope.usuario).success(function (response) {
    	  $scope.usuario = {};
    	  $scope.endereco = {};
    	  sucesso("Salvo com sucesso");
    	  $location.path('/usuarios');
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    }
    $scope.deletarUsuario = function (codigo) {
        $http.delete("users/"+codigo).success(function (response) {
        	sucesso("Excluido com sucesso");
        	$scope.listarUsuarios();
        }).error(function(response) {
			erro("Error: " + response);
		});
    }
    $scope.editarUsuario = function (codigo) {
        $http.get("users/"+codigo).success(function (response) {
        	$scope.usuario = response;
        	$location.path('/usuario/edit/'+codigo);
        }).error(function(response) {
			erro("Error: " + response);
        });
    }
    $scope.buscarUsuarios = function () {
        $http.get("users/buscar", $scope.usuario).success(function (response) {
        	$scope.usuarios = response;
        	$location.path('/usuarios');
        }).error(function(response) {
			erro("Error: " + response);
        });
    }

});
//mostra msg de sucesso
function sucesso(msg) {
    	$.notify({
        	message: msg
        },{
            type: 'success',
            timer: 1000
        });
}

//mostra msg de erro
function erro(msg) {
	$.notify({
    	message: msg

    },{
        type: 'danger',
        timer: 1000
    });
}
function formatObjectJson(object){
	var str = JSON.stringify(object);
	str = str.replace("\"{", "{").replace("}\"","}")
	console.log(str);
	str = replaceAll(str, "\\", "");
	return JSON.parse(str);
}
function replaceAll(string, token, newtoken) {
    while (string.indexOf(token) != -1) {
        string = string.replace(token, newtoken);
    }
    return string;
}

app.run(function($rootScope){
	$rootScope.usuarios = [];
});

//adiciona a imagem ao campo html img
function visualizarImg() {
	 var preview = document.querySelectorAll('img').item(1);
	  var file    = document.querySelector('input[type=file]').files[0];
	  var reader  = new FileReader();

	  reader.onloadend = function () {
	    preview.src = reader.result;// carrega em base64 a img
	  };

	  if (file) {
	    reader.readAsDataURL(file);		    
	  } else {
	    preview.src = "";
	  }
	  
}
