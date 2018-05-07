app.controller('disciplinaController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Disciplina";
		
		$http.get("disciplinas/" + $routeParams.id).success(function(response) {
			$scope.disciplina = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Nova Disciplina";
		$scope.disciplina = {};
	}

	$scope.listar = function(){
		$rootScope.title = "Disciplina";
		$http.get("disciplinas/findAll").success(function(data){
			$scope.disciplinas = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.criar = function () {
		$location.path('/disciplina/new');
    }
	$scope.cancelar = function () {
		$scope.disciplina = {};
		$location.path('/disciplinas');
    } 
    $scope.salvar = function () {
	    $http.post("disciplinas", $scope.disciplina).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    }
    $scope.deletar = function (codigo) {
        $http.delete("disciplinas/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/disciplinas');
        }, function(response) {
			erro("Error: " + response.data);
		});
    }
    $scope.editar = function (codigo) {
    	$location.path('/disciplina/edit/'+codigo);
    }
    $scope.buscar = function () {
        $http.post("disciplinas/buscar", $scope.disciplina).success(function (response) {
        	$scope.disciplinas = response;
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