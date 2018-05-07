app.controller('turmaController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	$rootScope.title = "Turma";
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Turma";
		
		$http.get("turmas/" + $routeParams.id).success(function(response) {
			$scope.turma = response;
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Nova Turma";
		$scope.turma = {};
	}
	$scope.init = function(){
		$http.get("turmas/situacao").success(function(data){
			$scope.situacoes = data;
		}).error(function(data){
			console.log("Error: " + data);
		});

		$http.get("turmas/niveis").success(function(data){
			$scope.niveis = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
		
		$http.get("turmas/professores").success(function(data){
			$scope.professores = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	};

	$scope.listar = function(){
		$rootScope.title = "Turma";
		$http.get("turmas/findAll").success(function(data){
			$scope.turmas = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	};
	$scope.criar = function () {
		$location.path('/turma/new');
    };
	$scope.cancelar = function () {
		$scope.turma = {};
		$location.path('/turmas');
    } ;
    $scope.salvar = function () {
    	var object = formatObjectJson($scope.turma);
	    $http.post("turmas", object).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    };
    $scope.deletar = function (codigo) {
        $http.delete("turmas/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/turmas');
        }, function(response) {
			erro("Error: " + response.data);
		});
    };
    $scope.editar = function (codigo) {
    	$location.path('/turma/edit/'+codigo);
    };
    $scope.buscar = function () {
        $http.post("turmas/buscar", $scope.turma).success(function (response) {
        	$scope.turmas = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
    };
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