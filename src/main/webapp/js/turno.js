app.controller('turnoController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	$rootScope.title = "Turno";
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Turno";
		
		$http.get("turnos/" + $routeParams.id).success(function(response) {
			$scope.turno = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Novo Turno";
		$scope.turno = {};
	}
	$scope.init = function(){

	};

	$scope.listar = function(){
		$rootScope.title = "Turno";
		$http.get("turnos/findAll").success(function(data){
			$scope.turnos = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	};
	$scope.criar = function () {
		$location.path('/turno/new');
    };
	$scope.cancelar = function () {
		$scope.turno = {};
		$location.path('/turnos');
    } ;
    $scope.salvar = function () {
//    	var object = formatObjectJson($scope.turno);
	    $http.post("turnos", $scope.turno).success(function (response) {
	    	if(response.message){
		    	erro(response.message);
	    	}else{
	    		$scope.cancelar();
		    	sucesso("Salvo com sucesso");
	    	}
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    };
    $scope.deletar = function (codigo) {
        $http.delete("turnos/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/turnos');
        }, function(response) {
			erro("Error: " + response.data);
		});
    };
    $scope.editar = function (codigo) {
    	$location.path('/turno/edit/'+codigo);
    };
});