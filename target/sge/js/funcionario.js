app.controller('funcionarioController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Funcionário";
		
		$http.get("funcionarios/" + $routeParams.id).success(function(response) {
			$scope.funcionario = response;
			$http.get("funcionarios/carregarSexo").success(function (response) {
	        	$scope.sexos = response;
	        }).error(function(response) {
				erro("Error: " + response);
	        });
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$rootScope.subtitulo = "Novo Funcionário";
		$scope.funcionario = {};
		$scope.medicamento = {};
		$scope.telefone = {};
		$scope.endereco = {};
		$http.get("funcionarios/carregarSexo").success(function (response) {
        	$scope.sexos = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
	}

	$scope.listar = function(){
		$scope.title = 'Funcionário';
		$http.get("funcionarios/findAll").success(function(data){
			$scope.funcionarios = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.criar = function () {
		$location.path('/funcionario/new');
    }
	$scope.cancelar = function () {
		$scope.funcionario = {};
		$scope.endereco = {};
		$scope.telefone = {};
		$scope.medicamento = {};
		$location.path('/funcionarios');
    } 
    $scope.salvar = function () {
    	$scope.funcionario.foto = document.getElementById("imagemPerfil").getAttribute("src");
	    $http.post("funcionarios", $scope.funcionario).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    }
    $scope.deletar = function (codigo) {
        $http.delete("funcionarios/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/funcionarios');
        }, function(response) {
			erro("Error: " + response.data);
		});
    }
    $scope.editar = function (codigo) {
    	$location.path('/funcionario/edit/'+codigo);
    }
    $scope.buscar = function () {
        $http.post("funcionarios/buscar", $scope.funcionario).success(function (response) {
        	$scope.funcionarios = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
    }

    $scope.adicionarEnderecos = function(){
    	if($scope.funcionario.enderecos){
    		$scope.funcionario.enderecos.push($scope.endereco);
    	}else{
    		$scope.funcionario.enderecos = [];
    		$scope.funcionario.enderecos.push($scope.endereco);
    	}
    	$scope.endereco = {};
    }
    $scope.excluirEndereco = function(index){
    	$scope.funcionario.enderecos.splice(index, 1);
    }
    
    $scope.adicionarTelefones = function(){
    	if($scope.funcionario.telefones){
    		$scope.funcionario.telefones.push($scope.telefone);
    	}else{
    		$scope.funcionario.telefones = [];
    		$scope.funcionario.telefones.push($scope.telefone);
    	}
    	$scope.telefone = {};
    }
    $scope.excluirTelefone = function(index){
    	$scope.funcionario.telefones.splice(index, 1);
    }
    
    $scope.selectImage = function() {
        CameraFactory.getPicture();
    };
});

