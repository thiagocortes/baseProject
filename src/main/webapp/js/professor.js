app.controller('professorController', function ($scope, $http, $rootScope, $location, $routeParams, $resource) {
	
	if ($routeParams.id != null && $routeParams.id != undefined && $routeParams.id != ''){
		$scope.subtitulo = "Editando Professor";
		
		$http.get("professores/" + $routeParams.id).success(function(response) {
			$scope.professor = response;
			$scope.professor.dataNascimento = ($scope.professor.dataNascimento, 'dd/MM/yyyy');
			$http.get("professores/carregarSexo").success(function (response) {
	        	$scope.sexos = response;
	        }).error(function(response) {
				erro("Error: " + response);
	        });
		}).error(function(data, status, headers, config) {
			erro("Error: " + status);
		});
		
	}else {
		$scope.subtitulo = "Novo Professor";
		$scope.professor = {};
		$scope.medicamento = {};
		$scope.telefone = {};
		$scope.endereco = {};
		$http.get("professores/carregarSexo").success(function (response) {
        	$scope.sexos = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
	}

	$scope.listar = function(){
		$rootScope.title = 'Professor';
		$http.get("professores/findAll").success(function(data){
			$scope.professores = data;
		}).error(function(data){
			console.log("Error: " + data);
		});
	}
	$scope.criar = function () {
		$location.path('/professor/new');
    }
	$scope.cancelar = function () {
		$scope.professor = {};
		$scope.endereco = {};
		$scope.telefone = {};
		$scope.medicamento = {};
		$location.path('/professores');
    } 
    $scope.salvar = function () {
    	$scope.professor.foto = document.getElementById("imagemPerfil").getAttribute("src");
	    $http.post("professores", $scope.professor).success(function (response) {
	    	$scope.cancelar();
	    	sucesso("Salvo com sucesso");
        }).error(function(response) {
		  erro("Error: " + response);
	    });
    }
    $scope.deletar = function (codigo) {
        $http.delete("professores/"+codigo).then(function (response) {
        	sucesso("Excluido com sucesso");
        	$location.path('/professores');
        }, function(response) {
			erro("Error: " + response.data);
		});
    }
    $scope.editar = function (codigo) {
    	$location.path('/professor/edit/'+codigo);
    }
    $scope.buscar = function () {
        $http.post("professores/buscar", $scope.professor).success(function (response) {
        	$scope.professores = response;
        }).error(function(response) {
			erro("Error: " + response);
        });
    }

    $scope.adicionarEnderecos = function(){
    	if($scope.professor.enderecos){
    		$scope.professor.enderecos.push($scope.endereco);
    	}else{
    		$scope.professor.enderecos = [];
    		$scope.professor.enderecos.push($scope.endereco);
    	}
    	$scope.endereco = {};
    }
    $scope.excluirEndereco = function(index){
    	$scope.professor.enderecos.splice(index, 1);
    }
    
    $scope.adicionarTelefones = function(){
    	if($scope.professor.telefones){
    		$scope.professor.telefones.push($scope.telefone);
    	}else{
    		$scope.professor.telefones = [];
    		$scope.professor.telefones.push($scope.telefone);
    	}
    	$scope.telefone = {};
    }
    $scope.excluirTelefone = function(index){
    	$scope.professor.telefones.splice(index, 1);
    }
    
    $scope.selectImage = function() {
        CameraFactory.getPicture();
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