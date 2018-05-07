app.controller('nivelController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Nível";
		
		$http.get("niveis/" + $routeParams.id).success(function(response) {
			cursos ();
			$scope.nivel = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Novo Nível";
		$scope.nivel = {};
		cursos ();
	}
	
	$http.get("niveis/situacao").success(function(data){
		$scope.situacoes = data;
	}).error(function(data){
		console.log("Error: " + data);
	});
	
	$scope.listar = function(){
		$rootScope.title = "Nível";
		$http.get("niveis/findAll").success(function(data){
			$scope.niveis = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.criar = function () {
		$location.path('/nivel/new');
    }
	$scope.cancelar = function () {
		$scope.nivel = {};
		$location.path('/niveis');
    } 
    $scope.salvar = function () {
    	var object = formatObjectJson($scope.nivel);
	    $http.post("niveis", object).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    }).finally(function(){
	    	console.log("finalizou");
	    });
    }
    $scope.deletar = function (codigo) {
        $http.delete("niveis/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/niveis');
        }, function(response) {
			erro("Error: " + response.data);
		});
    }
    $scope.editar = function (codigo) {
    	$location.path('/nivel/edit/'+codigo);
    }
    function cursos (){
    	
    	$http.get("niveis/cursos").success(function(data){
    		$scope.cursos = data;
    	}).error(function(data){
    		console.log("Error: " + data);
    	});
    }
    
});