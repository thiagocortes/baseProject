app.controller('horariosTurnoController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	$rootScope.title = "Horários Turnos";
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Horários Turnos";
		Iniciar();
		$http.get("horariosTurnos/" + $routeParams.id).success(function(response) {
			$scope.horariosTurno = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Novo Horários Turnos";
		$scope.horariosTurno = {};
		Iniciar();
	}

	$scope.listar = function(){
		$rootScope.title = "Horários Turnos";
		$http.get("horariosTurnos/findAll").success(function(data){
			$scope.horariosTurnos = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	};
	$scope.criar = function () {
		$location.path('/horariosTurno/new');
    };
	$scope.cancelar = function () {
		$scope.horariosTurno = {};
		$location.path('/horariosTurnos');
    } ;
    $scope.salvar = function () {
    	var object = formatObjectJson($scope.horariosTurno);
	    $http.post("horariosTurnos", object).success(function (response) {
	    	if(response.message){
		    	erro(response.message);
	    	}else{
	    		$scope.cancelar();
		    	sucesso("Salvo com sucesso");
	    	}
        }).error(function(response) {
		  erro("Error: " + response.errors);
	    });
    };
    $scope.deletar = function (codigo) {
        $http.delete("horariosTurnos/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/horariosTurnos');
        }, function(response) {
			erro("Error: " + response.data);
		});
    };
    $scope.editar = function (codigo) {
    	$location.path('/horariosTurno/edit/'+codigo);
    };
    
    function Iniciar(){
		
		$http.get("horariosTurnos/horarios").success(function(response) {
			$scope.horarios = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
		$http.get("horariosTurnos/turnos").success(function(response) {
			$scope.turnos = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
	};
});