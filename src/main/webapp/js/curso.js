app.controller('cursoController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Curso";
		$http.get("cursos/" + $routeParams.id).success(function(response) {
			$scope.curso = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Novo Curso";
		$scope.curso = {};
	}
	
	$http.get("cursos/situacao").success(function(data){
		$scope.situacao = data;
		console.log("Situação: " + data);
	}).error(function(data){
		console.log("Error: " + data);
	});

	$scope.listar = function(){
		$rootScope.title = "Curso";
		$http.get("cursos/findAll").success(function(data){
			$scope.cursos = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.criar = function () {
		$location.path('/curso/new');
    }
	$scope.cancelar = function () {
		$scope.curso = {};
		$location.path('/cursos');
    } 
    $scope.salvar = function () {
	    $http.post("cursos", $scope.curso).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    }
    $scope.deletar = function (codigo) {
        $http.delete("cursos/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/cursos');
        }, function(response) {
			erro("Error: " + response.data);
		});
    }
    $scope.editar = function (codigo) {
    	$location.path('/curso/edit/'+codigo);
    }
});